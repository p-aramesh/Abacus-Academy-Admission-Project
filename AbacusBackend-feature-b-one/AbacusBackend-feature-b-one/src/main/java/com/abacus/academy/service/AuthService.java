package com.examly.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.model.AdminModel;
import com.examly.model.LoginModel;
import com.examly.model.UserDAO;
import com.examly.model.UserModel;
import com.examly.repository.AdminRepo;
import com.examly.repository.LoginRepo;
import com.examly.repository.UserRepo;

@Service
public class AuthService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	LoginRepo loginRepo;

	public Map<String, Object> isUserPresent(LoginModel lm) {
		Map<String, Object> m = new HashMap<String, Object>();
		 Optional<LoginModel> ls= loginRepo.findById(lm.getEmail());
		System.out.println(ls.get().getEmail());
		 System.out.println(ls.get().getPassword());
		 
		 if(ls.get().getEmail().equalsIgnoreCase(lm.getEmail()) && ls.get().getPassword().equalsIgnoreCase(lm.getPassword()) && ls.get().getRole().equalsIgnoreCase(lm.getRole()))
		 {
			 m.put("userRole", loginRepo.findById(lm.getEmail()).get().getRole());
				m.put("status", 200);
		 }
			/*
			 * if(loginRepo.findById(lm.getEmail()).isPresent()) {
			 * if(lm.getPassword().equals(loginRepo.findById(lm.getEmail()).get().
			 * getPassword())) m.put("userRole",
			 * loginRepo.findById(lm.getEmail()).get().getRole()); m.put("status", 200);
			 */
//				return m;
//				return loginRepo.findById(lm.getEmail()).get().getUserRole();
//				return true;
	//	}
		else {
			m.put("message", "Login Failed");
			m.put("status", 400);
			
		}
		return m;
	}

	public Boolean isAdminPresent(LoginModel lm) {
		if(loginRepo.findById(lm.getEmail()).isPresent()) {
			if(lm.getPassword().equals(loginRepo.findById(lm.getEmail()).get().getPassword()))
				return true;
		}
		
		return false;
	}

	public Map<String, String> saveAdmin(AdminModel am) {
		
		Map<String, String> response = new HashMap<>();

		if(adminRepo.findById(am.getEmail()).isPresent()) {
			response.put("statusCode", "000");
			response.put("response", "Admin already present with the email:" + am.getEmail());
			return response;
		}
		else {
			System.out.println(am.toString());
			adminRepo.save(am);
			LoginModel lm = new LoginModel();
			lm.setEmail(am.getEmail());
			lm.setPassword(am.getPassword());
			loginRepo.save(lm);
			response.put("statusCode", "200");
			response.put("response", "Admin added");
			return response;
			
		}
	}

	public Map<String, String> saveUser(UserModel um) {
		Map<String, String> response = new HashMap<>();
		if(loginRepo.findById(um.getEmail()).isPresent()) {
			response.put("statusCode", "000");
			response.put("response", "User already present with the email: "+um.getEmail());
			return response;
		}
		else {
//			System.out.println(um.toString());
			userRepo.save(um);
			
//			LoginModel lm = new LoginModel();
//			lm.setEmail(um.getEmail());
//			lm.setPassword(um.getPassword());
//			loginRepo.save(lm);
			response.put("statusCode", "200");
			response.put("message", "User Aded");
			return response;
		}
	}

}
