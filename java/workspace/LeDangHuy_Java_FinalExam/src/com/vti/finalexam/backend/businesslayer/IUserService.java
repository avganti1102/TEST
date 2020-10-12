package com.vti.finalexam.backend.businesslayer;

import java.sql.SQLException;

public interface IUserService {
	
	public void registerManager(String firstName, String lastName, String phone, String email, String pass, int expInYear) throws SQLException ;
	
	public void registerEmployee(String firstName, String lastName, String phone, String email, String pass, String projectName, String proSkill) throws SQLException ;
	
	public boolean isUserExists(String email, String pass) throws SQLException ;
	
}
