package backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.service.IUserService;
import backend.service.UserService;
import entity.User;

public class UserController {
	private IUserService iUserService;
	
	public UserController() throws FileNotFoundException, IOException {
		iUserService = new UserService();
	}
	
	public boolean insertManager() throws SQLException {
		return iUserService.insertManager();
	}

	public List<User> showListManager() throws SQLException {
		return iUserService.showListManager();
	}

	public List<User> showListEmployee() throws SQLException {
		return iUserService.showListEmployee();
	}

	public boolean updateManager() throws SQLException {
		return iUserService.updateManager();
	}
}
