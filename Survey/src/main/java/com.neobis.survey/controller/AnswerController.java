package com.neobis.survey.controller;

import com.neobis.survey.entity.Answer;
import com.neobis.survey.service.AnswerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти ответ по id")
    public Answer getAnswer(@PathVariable("id") Integer id) throws Exception {
        return answerService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить ответ")
    public Answer putAnswer(@PathVariable("id") Integer id, @RequestBody Answer answer) throws Exception {
        answerService.changeById(id, answer);
        return answer;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать ответ")
    public Answer postAnswer(@RequestBody Answer answer) throws Exception {
        answerService.createAnswer(answer);
        return answer;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить ответ")
    public void deleteQuestion(@PathVariable("id") Integer id) {
        answerService.deleteById(id);
    }


}
