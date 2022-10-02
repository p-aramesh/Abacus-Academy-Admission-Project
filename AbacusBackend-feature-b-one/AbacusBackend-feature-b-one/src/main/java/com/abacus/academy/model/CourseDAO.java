package com.examly.model;

public class CourseDAO {

	private String courseName;
	
	private String courseDescription;
	
	private int courseDuration;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "CourseDAO [courseName=" + courseName + ", courseDescription=" + courseDescription + ", courseDuration="
				+ courseDuration + "]";
	}
}
