package com.neobis.survey.service;

import com.neobis.survey.entity.Question;
import com.neobis.survey.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question findById(Integer id) throws Exception {
        return questionRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        questionRepository.deleteById(id);
        return "QuestionController number " + id + " has been deleted!";
    }

    public Question changeById(Integer id, Question questionEntity) throws Exception {
        return questionRepository.findById(id)
                .map(question -> {
                    question.setDescription(questionEntity.getDescription());
                    question.setQuestionType(questionEntity.getQuestionType());
                    return questionRepository.save(question);
                }).orElseThrow(Exception::new);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

}
