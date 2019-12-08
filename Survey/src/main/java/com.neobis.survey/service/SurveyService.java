package com.neobis.survey.service;

import com.neobis.survey.entity.Survey;
import com.neobis.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    public Survey findById(Integer id) throws Exception {
        return surveyRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        surveyRepository.deleteById(id);
        return "Product number " + id + " has been deleted!";
    }

    public Survey changeById(Integer id, Survey surveyEntity) throws Exception {
        return surveyRepository.findById(id)
                .map(survey-> {
                    survey.setTitle(surveyEntity.getTitle());
                    survey.setType(surveyEntity.getType());
                    survey.setCode(surveyEntity.getCode());
                    survey.setDescription(surveyEntity.getDescription());
                    survey.setDuration(surveyEntity.getDuration());
                    survey.setQuestions(surveyEntity.getQuestions());
                    return surveyRepository.save(survey);
                }).orElseThrow( Exception::new);
    }

    public Survey createSurvey(Survey surveyEntity)  {
        return surveyRepository.save(surveyEntity);
    }

    public List<Survey> getAll(){
        return surveyRepository.findAll();
    }

}
