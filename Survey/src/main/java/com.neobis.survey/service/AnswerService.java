package com.neobis.survey.service;

import com.neobis.survey.entity.Answer;
import com.neobis.survey.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer findById(Integer id) throws Exception {
        return answerRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        answerRepository.deleteById(id);
        return "AnswerController number " + id + " has been deleted!";
    }

    public Answer changeById(Integer id, Answer answerEntity) throws Exception {
        return answerRepository.findById(id)
                .map(answer -> {
                    answer.setAnswer(answerEntity.getAnswer());
                    answer.setCorrect(answerEntity.getCorrect());
                    return answerRepository.save(answer);
                }).orElseThrow(Exception::new);
    }

    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> getAll() {
        return answerRepository.findAll();
    }


}
