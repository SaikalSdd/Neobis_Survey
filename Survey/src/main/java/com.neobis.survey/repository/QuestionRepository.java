package com.neobis.survey.repository;

import com.neobis.survey.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
}
