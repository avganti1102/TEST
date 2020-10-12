package backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.repository.IUserRepository;
import backend.repository.UserRepository;
import entity.User;

public class UserService implements IUserService {
	private IUserRepository iUserRepository;
	
	public UserService() throws IOException {
		iUserRepository = new UserRepository();
	}
	@Override
	public boolean insertManager() throws SQLException {
		return iUserRepository.insertManager();
	}
	@Override
	public List<User> showListManager() throws SQLException {
		return iUserRepository.showListManager();
	}
	@Override
	public List<User> showListEmployee() throws SQLException {
		return iUserRepository.showListEmployee();
	}
	@Override
	public boolean updateManager() throws SQLException {
		return iUserRepository.updateManager();
	}

}
