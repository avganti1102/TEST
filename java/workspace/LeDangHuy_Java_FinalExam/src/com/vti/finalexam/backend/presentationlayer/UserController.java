package com.vti.finalexam.backend.presentationlayer;

import java.sql.SQLException;

import com.vti.finalexam.backend.businesslayer.IUserService;
import com.vti.finalexam.backend.businesslayer.UserService;

public class UserController {
	
	private IUserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	public void registerManager(String firstName, String lastName, String Phone, String email, String pass, int expInYear) throws SQLException {
		userService.registerManager(firstName, lastName, Phone, email, pass, expInYear);
	}
	
	public void registerEmployee(String firstName, String lastName, String Phone, String email, String pass, String projectName, String proSkill) throws SQLException {
		userService.registerEmployee(firstName, lastName, Phone, email, pass, projectName, proSkill);
	}
	
	public boolean isUserExists(String email, String pass) throws SQLException {
		return userService.isUserExists(email, pass);
	}
	
}
