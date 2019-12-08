package com.neobis.survey.controller;

import com.neobis.survey.entity.Survey;
import com.neobis.survey.repository.SurveyRepository;
import com.neobis.survey.service.SurveyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти опрос по id")
    public Survey getSurvey(@PathVariable("id") Integer id) throws Exception {
        return surveyService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить опрос")
    public Survey putSurvey(@PathVariable("id") Integer id, @RequestBody Survey survey) throws Exception {
        surveyService.changeById(id, survey);
        return survey;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать опрос")
    public Survey postSurvey(@RequestBody Survey survey) throws Exception {
        surveyService.createSurvey(survey);
        return survey;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить опрос")
    public void deleteProduct(@PathVariable("id") Integer id) {
        surveyService.deleteById(id);
    }

//    @GetMapping(value = "/all")
//    @ApiOperation(value = "Получить все опросы")
//    public List<Survey> getAllSurveys() {
//        return SurveyService.getAll();
//    }

//
//    @GetMapping(value="/allbyrating")
//    @ApiOperation(value = "Получить все продукты по рейтингу")
//    public List<Survey> getAllProductsByRating() {
//        return surveyService.getAllByRating();
//    }
//
//
//    @GetMapping(value="/price/{low}/{high}")
//    @ApiOperation(value = "Поиск по названию")
//    public List<Survey> byPrice(@PathVariable (name = "low",required = false) BigDecimal low,
//                                @PathVariable ("high") BigDecimal high){
//        if (low == null){ low = BigDecimal.valueOf(0); }
//
//        return surveyService.getByTitle(low,high);
//    }
//
//    @GetMapping(value="/search/{text}")
//    @ApiOperation(value = "Поиск по имени")
//    public List<ProductEntity> byName(@PathVariable ("text") String text) {
//        if(text.equals("")){
//            return null;
//        }
//        else {
//            return productService.getByName(text);
//        }
//    }
}
