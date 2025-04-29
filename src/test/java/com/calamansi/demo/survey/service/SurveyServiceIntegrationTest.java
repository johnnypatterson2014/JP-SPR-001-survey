package com.calamansi.demo.survey.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.calamansi.demo.survey.SurveyTestConfig;
import com.calamansi.demo.survey.model.SurveyEntity;
import com.calamansi.demo.survey.model.SurveyRepo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(SurveyTestConfig.class)
public class SurveyServiceIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;

	@Autowired
	private SurveyService surveyService;
    
    @Test
    public void test_surveyService() {
        
    	surveyService.loadTestData();
    	SurveyEntity se = surveyService.findByName("fred");
    	assertNotNull(se);
    	assertEquals("fred", se.name);
    	
    }
    
}
