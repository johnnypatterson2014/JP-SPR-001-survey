package com.calamansi.demo.survey.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.calamansi.demo.survey.SurveyTestConfig;
import com.calamansi.demo.survey.model.SurveyEntity;
import com.calamansi.demo.survey.model.SurveyRepo;
import com.calamansi.demo.survey.service.SurveyService;

@ExtendWith(SpringExtension.class)
@Import(SurveyTestConfig.class)
public class SurveyServiceTest {

	@Autowired 
	private SurveyService surveyService;
	
	@MockBean
	private SurveyRepo surveyRepo;
	
	@BeforeEach
	public void setUp() {
		
		SurveyEntity se = new SurveyEntity();
		se.id = new Long(1);
		se.name = "fred";
		Optional<SurveyEntity> ose = Optional.ofNullable(se);
		
	    Mockito.when(surveyRepo.findByName(se.name))
	      .thenReturn(ose);
	}
	
	@Test
	public void testing() {
		
//		String myString = surveyService.getTestResponse();
//		assertEquals(myString, "{ \"test\":\"testing\"}");
		
		SurveyEntity se = surveyService.findByName("fred");
		assertNotNull(se);
		
	}
}
