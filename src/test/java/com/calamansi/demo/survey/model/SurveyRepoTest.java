package com.calamansi.demo.survey.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SurveyRepoTest {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SurveyRepo surveyRepository;
	
    @Test
    public void whenFindById_thenReturnSurveyEntity() {
        // given
    	SurveyEntity se = new SurveyEntity();
    	se.name = "fred";
        entityManager.persist(se);
        entityManager.flush();

        // when
        Optional<SurveyEntity> found = surveyRepository.findById(se.id);
        assert(found.isPresent());

        // then
        assertThat(found.get().name).isEqualTo("fred");
    }
    
}
