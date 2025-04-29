package com.calamansi.demo.survey;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.calamansi.demo.survey.service.SurveyService;

@TestConfiguration
public class SurveyTestConfig {

	@Bean
	public SurveyService exampleService() {
		return new SurveyService();
	}
}
