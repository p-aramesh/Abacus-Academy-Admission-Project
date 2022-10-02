package com.examly.model;

import java.time.LocalDate;

public class StudentDAO {

	private String studentName;
	
	private LocalDate studentDOB;
	
	private String address;
	
	private String mobile;
	
	private int Age;

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
		return "StudentDAO [studentName=" + studentName + ", studentDOB=" + studentDOB + ", address=" + address
				+ ", mobile=" + mobile + ", Age=" + Age + "]";
	}
	
}
