package com.examly.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class StudentModel {
	
	@Id
	@SequenceGenerator(name="student_seq_gen", sequenceName="student_seq_gen", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq_gen")
	private int studentId;
	
	private String studentName;
	
	private LocalDate studentDOB;
	
	private String address;
	
	private String mobile;
	
	private int Age;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public LocalDate getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(LocalDate studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", studentName=" + studentName + ", studentDOB=" + studentDOB
				+ ", address=" + address + ", mobile=" + mobile + ", Age=" + Age + "]";
	}
	
	
}
