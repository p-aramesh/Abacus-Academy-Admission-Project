package com.examly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.model.AdmissionModel;

@Repository
public interface AdmissionRepo extends JpaRepository<AdmissionModel,Integer>{

}