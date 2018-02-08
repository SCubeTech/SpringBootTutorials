package com.shree.springboot.controller;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shree.springboot.Application;
import com.shree.springboot.model.Question;
import com.shree.springboot.service.SurveyService;

@RestController
public class SurveyController {
	private static final Logger logger = LogManager.getLogger(SurveyController.class);
	@Autowired
	SurveyService service;
	
	@GetMapping(value="/surveys/{surveyId}/questions",produces="application/json")
	public List<Question> retreiveQuestion(@PathVariable String surveyId){
		logger.debug("Entering retreiveQuestion");
		logger.debug("Exiting retreiveQuestion");
		return service.retreiveQuestions(surveyId); 
		
	}
	
	@GetMapping(value="/surveys/{surveyId}/questions/{questionId}",produces="application/json")
	public Question retreiveQuestion(@PathVariable String surveyId,@PathVariable String questionId){
		
		logger.debug("Entering retreiveQuestiona");
		logger.debug("Exiting retreiveQuestiona");
		return service.retreiveQuestion(surveyId, questionId);
	}

	@PostMapping(value="/surveys/{surveyId}/questions",produces="application/json")
	public ResponseEntity<?> addQuestion(@PathVariable String surveyId,@RequestBody Question questionId){
		Question question = service.addQuestion(surveyId, questionId);
			if(question==null) {
				return ResponseEntity.noContent().build();
			}
	 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		                .path("/{id}").buildAndExpand(question.getId()).toUri();
	 

		return ResponseEntity.created(location).build();
	}
}