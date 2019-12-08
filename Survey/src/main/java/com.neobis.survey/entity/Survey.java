package com.neobis.survey.entity;

import com.neobis.survey.entity.enums.SurveyTypes;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "survey")
public class Survey{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Integer id;

    @Column(name = "title", length = 255)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private String type;

    @Column(name = "code")
    private Integer code;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "duration", length = 10)
    private String duration;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id", referencedColumnName = "survey_id")
    private List<Question> questions;

    @Column(name = "user_id")
    private Integer userId;

    public Survey(){

    }

    public Survey(String title, String type, Integer code, String description, String duration, List<Question> questions, Integer userId) {
        this.title = title;
        this.type = type;
        this.code = code;
        this.description = description;
        this.duration = duration;
        this.questions = questions;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
