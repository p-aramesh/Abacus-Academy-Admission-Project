package com.examly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.model.AdminModel;
import com.examly.model.StudentModel;


@Repository
public interface StudentRepo extends JpaRepository<StudentModel,Integer>{

}