package com.neobis.survey.service;

import com.neobis.survey.entity.User;
import com.neobis.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(String id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(String id) {
        userRepository.deleteById(id);
        return "Survey " + id + " has been deleted!";
    }

    public User changeById(String id,User userEntity) throws Exception {
        return userRepository.findById(id)
                .map(user-> {
                    user.setName(userEntity.getName());
                    user.setBirthDate(userEntity.getBirthDate());
                    user.setGender(userEntity.getGender());
                    user.setCountry(userEntity.getCountry());
                    user.setCity(userEntity.getCity());
                    user.setEmail(userEntity.getEmail());
                    user.setPhone(userEntity.getPhone());
                    user.setPicture(userEntity.getPicture());
                    user.setCreated(userEntity.getCreated());
                    user.setUpdated(userEntity.getUpdated());
                    userEntity.setAge(userEntity.getAge());
                    return userRepository.save(user);
                }).orElseThrow( Exception::new);
    }

    public User createUser(User userEntity)  {
        return userRepository.save(userEntity);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

}
