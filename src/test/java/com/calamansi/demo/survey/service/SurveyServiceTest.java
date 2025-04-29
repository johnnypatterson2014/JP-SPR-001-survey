package com.calamansi.demo.survey.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.calamansi.demo.survey.SurveyTestConfig;
import com.calamansi.demo.survey.service.SurveyService;

@ExtendWith(SpringExtension.class)
@Import(SurveyTestConfig.class)
public class SurveyServiceTest {

	@Autowired 
	private SurveyService exampleService;
	
	@Test
	public void testing() {
		
		String myString = exampleService.getTestResponse();
		assertEquals(myString, "{ \"test\":\"testing\"}");
		
	}
}
