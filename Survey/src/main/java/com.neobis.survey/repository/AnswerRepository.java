package com.neobis.survey.repository;

import com.neobis.survey.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{
}
