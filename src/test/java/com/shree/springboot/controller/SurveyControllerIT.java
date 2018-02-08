package com.shree.springboot.controller;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.shree.springboot.Application;
import com.shree.springboot.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {
	
	@LocalServerPort
	private int port;
	
	private TestRestTemplate template = new TestRestTemplate();
	
	

	@Test
	public void retreiveSurveyQuestion() {
		
		String extractQuestion1 = "/surveys/SurveyId1/questions/Question1";
		String url = createURL1(extractQuestion1);
		
		TestRestTemplate restTest =  new TestRestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTest.exchange(url, HttpMethod.GET, entity, String.class);
		

		String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";

		System.out.println(response.getBody());
		JSONAssert.assertEquals(expected, response.getBody(), false);
		
		//fail("Not yet implemented");
	}

	
	@Test
	public void retreiveSurveyAllQuestion() {
		
		String etractAllQuestions = "/surveys/SurveyId1/questions";
		String url = createURL1(etractAllQuestions);
		
		TestRestTemplate restTest =  new TestRestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<List<Question>> response = restTest.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Question>>() { });
		

		//String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";

		Question expected = new Question("Question1", "Largest country in the world", "Russia",Arrays.asList(
				"India", "Russia", "United States", "China"));
		System.out.println(response.getBody());
		assertTrue(response.getBody().contains(expected));
		
		
		//fail("Not yet implemented");
	}

	private String createURL1(String etractAllQuestions) {
		return "http://localhost:"+port+etractAllQuestions;
	}
	
	@Test
	public void insertQuestion() {
		String etractAllQuestions = "/surveys/SurveyId1/questions";
		
		String url = createURL1(etractAllQuestions);
		
		TestRestTemplate restTest =  new TestRestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Question expected = new Question("Question1", "Largest country in the world", "Russia",Arrays.asList(
				"India", "Russia", "United States", "China"));
		
		HttpEntity<Question> entity = new HttpEntity<Question>(expected, headers);
		
		ResponseEntity<String> response = restTest.exchange(url, HttpMethod.POST, entity, String.class);
		

		//String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";

		
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		
		System.out.println(actual);
		
		assertTrue(actual.contains("/surveys/SurveyId1/questions"));
		
		
		//fail("Not yet implemented");
	}

}
