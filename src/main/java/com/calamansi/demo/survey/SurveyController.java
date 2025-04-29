package com.calamansi.demo.survey;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calamansi.demo.survey.model.SurveyEntity;
import com.calamansi.demo.survey.service.SurveyService;

@RestController
@RequestMapping("/api")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/survey/load-data")
	public void loadData() {
		surveyService.loadTestData();
	}
	
	@GetMapping("/survey")
	SurveyEntity getSurveyByName(@RequestParam Map<String,String> qparams) {
		
		SurveyEntity se = surveyService.findByName(qparams.get("name"));
		return se;
	}
	
	@GetMapping("/survey/{id}")
	SurveyEntity getSurveyById(@PathVariable String id) {
		
		SurveyEntity se = surveyService.findById(id);
		return se;
		
	}
}
