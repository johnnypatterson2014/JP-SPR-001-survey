package com.calamansi.demo.survey.service;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	public String getTestResponse() {
		return "{ \"test\":\"testing\"}";
	}

}
