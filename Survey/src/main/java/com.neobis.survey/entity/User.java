package com.neobis.survey.entity;

import com.neovisionaries.i18n.CountryCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private String gender;

    @Column(name = "country", length = 2)
    private String country;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "picture", length = 255)
    private String picture;

    @Column(name = "created", length = 255)
    private String created;

    @Column(name = "updated", length = 255)
    private String updated;

    @Column(name = "age")
    private Integer age;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    private List<Survey> surveys;
//


    public User() {
    }

    public User(Integer id, String name, LocalDate birthDate, String gender, String country, String city, String email, String phone, String picture, String created, String updated, Integer age, List<Survey> surveys) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.picture = picture;
        this.created = created;
        this.updated = updated;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return String.valueOf(CountryCode.getByCode(country));
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setAge(Integer age) {
        LocalDate l =  birthDate;
        LocalDate now = LocalDate.now();
        Period diff = Period.between(l, now);
        age = diff.getYears();
        this.age = age;
    }

    public Integer getAge(){
        return age;
    }


}