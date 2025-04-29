package com.calamansi.demo.survey.model;


import java.util.Iterator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "survey")
public class SurveyEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	public String name;
	

}
