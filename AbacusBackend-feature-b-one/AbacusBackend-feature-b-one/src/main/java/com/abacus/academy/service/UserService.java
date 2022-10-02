package com.examly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.exception.NotFound;
import com.examly.model.AdmissionDAO;
import com.examly.model.AdmissionModel;
import com.examly.model.UserModel;
import com.examly.repository.AdmissionRepo;
import com.examly.repository.CourseRepo;
import com.examly.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AdmissionRepo admissionRepo;
	
	@Autowired
	CourseRepo courseRepo;
	
	
	public String addAdmission(AdmissionDAO admissionDAO) {
		if(userRepo.findById(admissionDAO.getUserEmail()).isPresent()) {
			if(courseRepo.findById(admissionDAO.getCourseId()).isPresent()) {
				AdmissionModel am = new AdmissionModel();
				am.setAdmissionDate(admissionDAO.getJoiningDate());
				am.setCourseModel(courseRepo.findById(admissionDAO.getCourseId()).get());
				am.setStatus("Pending");

				UserModel um = userRepo.findById(admissionDAO.getUserEmail()).get();
				
				List<AdmissionModel> admissionList = um.getAdmissions();
				admissionList.add(am);

				um.setAdmissions(admissionList);
				userRepo.save(um);
				return "Admission added";
			}
			else {
				return "Course not present with id:"+admissionDAO.getCourseId();
			}
		}
		else {
			return "user with Email not found";
		}
	}

	public List<AdmissionModel> viewAdmission(String email) throws NotFound {

		if(userRepo.findById(email).isPresent()) {
			return userRepo.findById(email).get().getAdmissions();
		}
		else {
			throw new NotFound("User not found with email: "+email);
		}
	}

	public String editAdmission(int enrolId, AdmissionDAO admissionDAO) {

		if(admissionRepo.findById(enrolId).isPresent()) {
			if(userRepo.findById(admissionDAO.getUserEmail()).isPresent()) {
				if(courseRepo.findById(admissionDAO.getCourseId()).isPresent()) {
					AdmissionModel am = admissionRepo.findById(enrolId).get();
					am.setAdmissionDate(admissionDAO.getJoiningDate());
					am.setCourseModel(courseRepo.findById(admissionDAO.getCourseId()).get());
					am.setStatus("Pending");
					
					UserModel um = userRepo.findById(admissionDAO.getUserEmail()).get();
					
					List<AdmissionModel> admissionList = um.getAdmissions();
					admissionList.add(am);
	
					um.setAdmissions(admissionList);
					userRepo.save(um);
					return "Admission edited";
				}
				else {
					return "Course not present with id:"+admissionDAO.getCourseId();
				}
			}
			else {
				return "user with Email not found: "+admissionDAO.getUserEmail();
			}
		}
		else {
			return "Admission not found with id"+enrolId;
		}
	}

	public String deleteAdmission(int enrolId) {
		if(admissionRepo.findById(enrolId).isPresent()) {
			AdmissionModel am = admissionRepo.findById(enrolId).get();
			am.setCourseModel(null);
			admissionRepo.save(am);
			admissionRepo.deleteById(enrolId);
			return "Admission Deleted";
		}
		else {
			return "Application not found with ID: "+enrolId;
		}
	}

	public String viewStatus(int applicationId) {

		if(admissionRepo.findById(applicationId).isPresent()) {
			return admissionRepo.findById(applicationId).get().getStatus();
		}
		else {
			return "Application not found with ID: "+applicationId;
		}
	}

	
	
}
