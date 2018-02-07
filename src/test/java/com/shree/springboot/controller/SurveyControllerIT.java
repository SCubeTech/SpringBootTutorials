package com.shree.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.shree.springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {
	
	@LocalServerPort
	private int port;
	
	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void retreiveSurveyQuestion() {
		
		String url = "http://localhost:"+port+"/surveys/Survey1/questions/Question1";
		
		
		
		//fail("Not yet implemented");
	}

}
