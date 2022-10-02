package com.ex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.exception.NotFound;
import com.examly.model.AdminModel;
import com.examly.model.CourseDAO;
import com.examly.model.CourseModel;
import com.examly.model.InstituteDAO;
import com.examly.model.InstituteModel;
import com.examly.model.StudentDAO;
import com.examly.model.StudentModel;
import com.examly.repository.AdminRepo;
import com.examly.repository.CourseRepo;
import com.examly.repository.InstituteRepo;
import com.examly.repository.StudentRepo;

import net.bytebuddy.asm.Advice.Return;

@Service
public class AdminService {

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	InstituteRepo instituteRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	AdminRepo adminRepo;
	

	public String addCourse(CourseDAO courseDAO) {
		try {
			CourseModel cm = new CourseModel();
			cm.setCourseName(courseDAO.getCourseName());
			cm.setCourseDescription(courseDAO.getCourseDescription());
			cm.setCourseDuration(courseDAO.getCourseDuration());
			//id will generate automatic;
			
			courseRepo.save(cm);
			return "Course added";
		}
		catch(Exception e) {
			System.out.println("failed addming course: "+e.getMessage());
		}
		return "Course Adding failed";
	}

	public List<CourseModel> viewCourse() {

		return courseRepo.findAll();
	}

	public String editCourse(int courseId, CourseDAO courseDAO) throws NotFound {
		if(courseRepo.findById(courseId).isPresent()) {
			CourseModel existingCourse = courseRepo.findById(courseId).get();

			existingCourse.setCourseName(courseDAO.getCourseName());
			existingCourse.setCourseDescription(courseDAO.getCourseDescription());
			existingCourse.setCourseDuration(courseDAO.getCourseDuration());
			
			courseRepo.save(existingCourse);
			return "Course edited";
		}else {
			throw new NotFound("Course Not Found with id: "+courseId);
		}
	}

	public String deleteCourse(int courseId) throws NotFound {
		
		if(courseRepo.findById(courseId).isPresent()) {
			courseRepo.deleteById(courseId);
			return "Course deleted";
		}else {
			throw new NotFound("Course Not Found with id: "+courseId);
		}
	}

	public Map<String, Object> addInstitute(InstituteModel instituteModel) {
		Map<String, Object> mp = new HashMap<String, Object>();
		try {
//			InstituteModel im = new InstituteModel();
//			im.setInstituteName(instituteDAO.getInstituteName());
//			im.setEmail(instituteDAO.getEmail());
//			im.setInstituteAddress(instituteDAO.getInstituteAddress());
//			im.setInstituteDescription(instituteDAO.getInstituteAddress());
//			im.setMobile(instituteDAO.getMobile());
//			im.setImgUrl(instituteDAO.getImgUrl());
//			System.out.println("insttttt   "+instituteModel.getInstituteName());
			InstituteModel obj = instituteRepo.findByInstituteName(instituteModel.getInstituteName());
			if(obj != null) {
				mp.put("status", 200);
				mp.put("message", "Duplicate Entry Found");
				mp.put("duplicate", true);
				return mp;
					
			}else {
				instituteRepo.save(instituteModel);
				mp.put("status", 200);
				mp.put("message", "Saved Successfully");
				mp.put("duplicate", false);
				return mp;
			}
		}
		catch(Exception e) {
			System.out.println("failed addming Institue: "+e.getMessage());
		}
		return mp;
	}

	public List<InstituteModel> viewInstitute() {

		return instituteRepo.findAll();
	}

	public String editInstitute(int instituteId, InstituteDAO instituteDAO) throws NotFound {
		
		if(instituteRepo.findById(instituteId).isPresent()) {

			InstituteModel existingInstitute = instituteRepo.findById(instituteId).get();
			existingInstitute.setInstituteName(instituteDAO.getInstituteName());
			existingInstitute.setEmail(instituteDAO.getEmail());
			existingInstitute.setInstituteAddress(instituteDAO.getInstituteAddress());
			existingInstitute.setInstituteDescription(instituteDAO.getInstituteAddress());
			existingInstitute.setMobile(instituteDAO.getMobile());
			
			instituteRepo.save(existingInstitute);
			return "Institue edited";
		}
		else {
			throw new NotFound("Institute Not Found with id: "+instituteId);
		}
	}

	public Map deleteInstitute(int instituteId)  throws NotFound {
		Map map = new HashMap();
		
		if(instituteRepo.findById(instituteId).isPresent()) {
			instituteRepo.deleteById(instituteId);
			map.put("statuscode", 200);
			map.put("message", "Deleted sucessfully");
			return map;
		}
		else {
			throw new NotFound("Institute Not Found with id: "+instituteId);
		}
	}

	public String addStudent(StudentDAO studentDAO) {
		try {
			StudentModel sm = new StudentModel();
			sm.setAddress(studentDAO.getAddress());
			sm.setAge(studentDAO.getAge());
			sm.setMobile(studentDAO.getMobile());
			sm.setStudentDOB(studentDAO.getStudentDOB());
			sm.setStudentName(studentDAO.getStudentName());
			studentRepo.save(sm);
			return "Student added";
			
		}
		catch(Exception e) {
			return "Student adding Failed";
		}
	}

	public List<StudentModel> viewStudent() {

		return studentRepo.findAll();
	}

	public String editStudent(int studentId, StudentDAO studentDAO) throws NotFound {
		if(studentRepo.findById(studentId).isPresent()) {

			StudentModel existingStudent = studentRepo.findById(studentId).get();
			existingStudent.setAddress(studentDAO.getAddress());
			existingStudent.setAge(studentDAO.getAge());
			existingStudent.setMobile(studentDAO.getMobile());
			existingStudent.setStudentDOB(studentDAO.getStudentDOB());
			existingStudent.setStudentName(studentDAO.getStudentName());
			studentRepo.save(existingStudent);
			return "Student edited";
		}else {
			throw new NotFound("Student Not Found with id: "+studentId);
		}
	}

	public String deleteStudent(int studentId)  throws NotFound {
	
		if(studentRepo.findById(studentId).isPresent()) {
			studentRepo.deleteById(studentId);
			return "Student deleted";
		}else {
			throw new NotFound("Student Not Found with id: "+studentId);
		}
	}
	public Map<String, Object> getAdmin(){
		Map<String, Object> response = new HashMap<>();
		
		 List<AdminModel> list = new ArrayList<>();
		 list= adminRepo.findAll();
		 response.put("statusCode", "200");
			response.put("response", list);
			
	return	response;
	}
	
	
}
