package com.calamansi.demo.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calamansi.demo.survey.service.SurveyService;

@RestController
@RequestMapping("/api")
public class SurveyController {

	@Autowired
	private SurveyService serveyService;
	
	@GetMapping("/survey")
	String getTest() {
		String testing = serveyService.getTestResponse();
		return testing;
	}
}
