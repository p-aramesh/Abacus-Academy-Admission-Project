package com.examly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.model.LoginModel;
import com.examly.model.UserModel;

@Repository
public interface LoginRepo extends JpaRepository<LoginModel,String>{

}
