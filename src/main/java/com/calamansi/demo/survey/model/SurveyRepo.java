package com.calamansi.demo.survey.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepo extends JpaRepository<SurveyEntity, Long>{

	public Optional<SurveyEntity> findById(Long id);
	public Optional<SurveyEntity> findByName(String name);
//	public SurveyEntity save(SurveyEntity entity);
//	public List<SurveyEntity> saveAll(List<SurveyEntity> entities);
}
