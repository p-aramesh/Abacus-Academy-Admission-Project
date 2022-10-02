package com.examly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.model.InstituteModel;

@Repository
public interface InstituteRepo extends JpaRepository<InstituteModel,Integer>{
	public InstituteModel findByInstituteName(String name);
}