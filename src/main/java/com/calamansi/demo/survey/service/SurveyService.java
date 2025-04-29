package com.calamansi.demo.survey.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calamansi.demo.survey.model.SurveyEntity;
import com.calamansi.demo.survey.model.SurveyRepo;

@Service
public class SurveyService {
	
	@Autowired
	private SurveyRepo surveyRepo;

//	public String getTestResponse() {
//		return "{ \"test\":\"testing\"}";
//	}

	public void loadTestData() {
		
		List<SurveyEntity> entityList = new ArrayList<SurveyEntity>();
		
		SurveyEntity se1 = new SurveyEntity();
    	se1.name = "my survey 1";
    	entityList.add(se1);
    	
    	SurveyEntity se2 = new SurveyEntity();
    	se2.name = "my survey 2";
    	entityList.add(se2);
    	
    	SurveyEntity se3 = new SurveyEntity();
    	se3.name = "my survey 3";
    	entityList.add(se3);
    	
    	SurveyEntity se4 = new SurveyEntity();
    	se4.name = "fred";
    	entityList.add(se4);
    	
    	surveyRepo.saveAllAndFlush(entityList);
		
	}

	public SurveyEntity findById(String id) {
		
		Optional<SurveyEntity> seo = surveyRepo.findById(Long.getLong(id));
		return seo.get();
		
	}

	public SurveyEntity findByName(String name) {
		
		Optional<SurveyEntity> seo = surveyRepo.findByName(name);
		return seo.get();
		
	}

}
