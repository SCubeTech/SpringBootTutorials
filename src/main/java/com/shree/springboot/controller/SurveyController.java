package com.shree.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shree.springboot.model.Question;
import com.shree.springboot.service.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
	SurveyService service;
	
	@GetMapping(value="/surveys/{surveyId}/questions",produces="application/xml")
	public List<Question> retreiveQuestion(@PathVariable String surveyId){
		return service.retreiveQuestions(surveyId); 
	}
	
	@GetMapping(value="/surveys/{surveyId}/questions/{questionId}",produces="application/xml")
	public Question retreiveQuestion(@PathVariable String surveyId,@PathVariable String questionId){
		return service.retreiveQuestion(surveyId, questionId);
	}
	
	@PostMapping(value="/surveys/{surveyId}/questions",produces="application/xml")
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