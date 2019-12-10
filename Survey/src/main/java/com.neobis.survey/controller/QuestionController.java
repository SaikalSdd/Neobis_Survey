package com.neobis.survey.controller;

import com.neobis.survey.entity.Question;
import com.neobis.survey.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти вопрос по id")
    public Question getQuestion(@PathVariable("id") Integer id) throws Exception {
        return questionService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить вопрос")
    public Question putQuestion(@PathVariable("id") Integer id, @RequestBody Question question) throws Exception {
        questionService.changeById(id, question);
        return question;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать вопрос")
    public Question postQuestion(@RequestBody Question question) throws Exception {
        questionService.createQuestion(question);
        return question;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить вопрос")
    public void deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteById(id);
    }


}
