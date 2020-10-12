package com.vti.finalexam.backend.datalayer;

import java.sql.SQLException;

public interface IUserReponsitory {
	public void registerManager(String firstName, String lastName, String phone, String email, String pass, int expInYear) throws SQLException ;
	
	public void registerEmployee(String firstName, String lastName, String phone, String email, String pass, String projectName, String proSkill) throws SQLException ;
	
	public boolean isUserExists(String email, String pass) throws SQLException ;
}
