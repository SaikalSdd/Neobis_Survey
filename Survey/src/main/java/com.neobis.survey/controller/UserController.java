package com.neobis.survey.controller;

import com.neobis.survey.entity.User;
import com.neobis.survey.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Найти юзера по id")
    public User getUser(@PathVariable ("id") String id) throws Exception{
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Создать юзера")
    public User postUser(@RequestBody User userEntity) throws Exception {
        userService.createUser(userEntity);
        return userEntity;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Изменить настройки юзера")
    public User putUser(@PathVariable ("id") String id ,@RequestBody User userEntity) throws Exception {
        userService.changeById(id,userEntity);
        return userEntity;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удалить юзера")
    public void deleteUser(@PathVariable ("id") String id) {
        userService.deleteById(id);
    }

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить всех юзеров")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}