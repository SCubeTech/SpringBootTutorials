package com.shree.springboot.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shree.springboot.model.Question;
import com.shree.springboot.model.Survey;

@Component
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1",
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question2 = new Question("Question2",
				"Most Populus Country in the World", "China", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question3 = new Question("Question3",
				"Highest GDP in the World", "United States", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question4 = new Question("Question4",
				"Second largest english speaking country", "India", Arrays
						.asList("India", "Russia", "United States", "China"));
		
		List<Question> questions = new ArrayList(Arrays.asList(question1,question2,question3,question4));
		
		Survey survey = new Survey("SurveyId1","SurveyTitle1","SurveyDescription1",questions);
		
		surveys = Arrays.asList(survey);
	}
	
	public List<Survey> retreiveAllSurveys(){
		return surveys;
	}
	
	public Survey retreiveSurveyId(String surveyId) {
		for(Survey survey: surveys) {
			if(survey.getId().equalsIgnoreCase(surveyId)) {
				return survey;
			}
		}
		return null;
	}
	
	public List<Question> retreiveQuestions(String surveyId){
		for(Survey survey: surveys) {
			if(survey.getId().equalsIgnoreCase(surveyId)) {
				return survey.getQuestions();
			}
		}
		return null;
	}
	
	public Question retreiveQuestion(String surveyId,String questionId) {
		List<Question> questions = retreiveQuestions(surveyId);
		if(null!=questions) {
			for(Question question:questions) {
				if(question.getId().equalsIgnoreCase(questionId)) {
					return question;
				}
			}
		}
		return null;
	}
	
	private SecureRandom random = new SecureRandom();

	
	public Question addQuestion(String surveyId,Question question) {
		Survey survey = retreiveSurveyId(surveyId);
		if(survey == null) {
			return null;
		}
		
		String randomId = new BigInteger(130, random).toString(32);
		question.setId(randomId);

		survey.getQuestions().add(question);

		return question;
	}
}
