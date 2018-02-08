package com.shree.springboot.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.shree.springboot.model.Question;
import com.shree.springboot.service.SurveyService;

@RunWith(SpringRunner.class)
//Call only the surveyController
@WebMvcTest(SurveyController.class)
public class SurveyControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	SurveyService service;
	
//	@Test
//	public void retrevieAllQuestions() throws Exception {
//		
//		//Initalize a default question
//		Question mockQuestion = new Question("Question1",
//				"Largest Country in the World", "Russia", Arrays.asList(
//						"India", "Russia", "United States", "China")); 
//		
//		
//		//Mock the service call
//		Mockito.when(service.retreiveQuestion(Mockito.anyString(),Mockito.anyString())).thenReturn(mockQuestion);
//		
//		RequestBuilder builder = MockMvcRequestBuilders.get("/surveys/Survey1/questions/Question1").accept(
//				MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(builder).andReturn();
//		
//		//Expected Result
//		String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";
//
//		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
//		
//	}
	
	@Test
	public void addQuestionMockTest() throws Exception {
		
		Question mockQuestion = new Question("Question1",
				"Largest Country in the World", "Russia111", Arrays.asList(
						"India", "Russia", "United States111", "China")); 
		
		String questionJson = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";
		Mockito.when(service.addQuestion(Mockito.anyString(), Mockito.any(Question.class))).thenReturn(mockQuestion);
		
		RequestBuilder builder = MockMvcRequestBuilders.post("/surveys/Survey1/questions").accept(MediaType.APPLICATION_JSON).content(questionJson).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(builder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		System.out.println(result.getResponse().toString());
		
		assertEquals(HttpStatus.CREATED.value(),response.getStatus());
		
		//assertEquals("http://localhost/surveys/Survey1/questions/1",response.getHeader(HttpHeaders.LOCATION));
		
	}
	
	
	
}
