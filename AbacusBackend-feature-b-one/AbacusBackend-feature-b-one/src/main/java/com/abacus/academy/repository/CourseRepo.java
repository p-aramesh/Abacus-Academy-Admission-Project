package com.examly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.model.CourseModel;


@Repository
public interface CourseRepo extends JpaRepository<CourseModel,Integer>{

}