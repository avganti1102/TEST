package com.vti.final_exam.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.vti.final_exam.entity.Employee;
import com.vti.final_exam.entity.Manager;

public interface IUserService {

	List<Employee> showProjectByEmployee(int id) throws SQLException;

	List<Manager> showProjectByManager(int id) throws SQLException;

	List<Manager> showListManager() throws SQLException;

	boolean isManagerExists(String email, String psw) throws SQLException;

	boolean isEmployeeExists(String email,String psw) throws SQLException;
	
}
