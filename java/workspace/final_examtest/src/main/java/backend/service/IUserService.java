package backend.service;

import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface IUserService {
	public boolean insertManager() throws SQLException;

	public List<User> showListManager() throws SQLException;

	public List<User> showListEmployee() throws SQLException;

	public boolean updateManager() throws SQLException;
}
