package com.examly.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.exception.NotFound;
import com.examly.model.AdminModel;
import com.examly.model.CourseDAO;
import com.examly.model.CourseModel;
import com.examly.model.InstituteDAO;
import com.examly.model.InstituteModel;
import com.examly.model.LoginModel;
import com.examly.model.StudentDAO;
import com.examly.model.StudentModel;
import com.examly.service.AdminService;

@CrossOrigin("*")
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin/addCourse")
	String addCourse(@RequestBody CourseDAO courseDAO) {
		return adminService.addCourse(courseDAO);
	}
	
	@GetMapping("/admin/viewCourse")
	List<CourseModel> viewCourse() {
		return adminService.viewCourse();	
	}
	
	@PutMapping("/admin/editCourse/{courseId}")
	String editCourse(@PathVariable int courseId, @RequestBody CourseDAO courseDAO) throws NotFound {
		
		return adminService.editCourse(courseId,courseDAO);
	}
	
	@DeleteMapping("/admin/deleteCourse")
	String deleteCourse(@RequestParam int courseId) throws NotFound {
		return adminService.deleteCourse(courseId);
	}
	
	@PostMapping("/admin/addInstitute")
	Map<String, Object> addInstitute(@RequestBody InstituteModel instituteModel) {
		return adminService.addInstitute(instituteModel);
	}
	
	@GetMapping("/admin/viewInstitute")
	List<InstituteModel> viewInstitute() {
		return adminService.viewInstitute();
	}
	
	@PutMapping("/admin/editInstitute/{instituteId}")
	String editInstitute(@PathVariable int instituteId, @RequestBody InstituteDAO instituteDAO) throws NotFound {
		
		return adminService.editInstitute(instituteId,instituteDAO);
	}
	
	@DeleteMapping("/admin/deleteInstitute")
	Map deleteInstitute(@RequestParam int instituteId) throws NotFound {
		return adminService.deleteInstitute(instituteId);
	}
	
	@PostMapping("/admin/addStudent")
	String addStudent(@RequestBody StudentDAO studentDAO) {
		return adminService.addStudent(studentDAO);
	}
	
	@GetMapping("/admin/viewStudent")
	List<StudentModel> viewStudent() {
		return adminService.viewStudent();
	}
	
	@PutMapping("/admin/editStudent/{studentId}")
	String editStudent(@PathVariable int studentId, @RequestBody StudentDAO studentDAO) throws NotFound {
		
		return adminService.editStudent(studentId,studentDAO);
	}
	
	@DeleteMapping("/admin/deleteStudent")
	String deleteStudent(@RequestParam int studentId) throws NotFound {
		return adminService.deleteStudent(studentId);
	}
	@GetMapping("/admin/data")
	public Map<String, Object> getAllAdmin(){
		return adminService.getAdmin();
	}

}
