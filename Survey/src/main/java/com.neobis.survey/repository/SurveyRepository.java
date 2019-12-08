package com.neobis.survey.repository;

import com.neobis.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    List<Survey> findByTitle(String title);
}