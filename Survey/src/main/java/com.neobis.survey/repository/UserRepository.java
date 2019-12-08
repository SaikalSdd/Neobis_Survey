package com.neobis.survey.repository;

import com.neobis.survey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findById(Integer id);
}