package backend.repository;

import java.sql.SQLException;
import java.util.List;

import entity.User;

public interface IUserRepository {
	boolean insertManager() throws SQLException;

	List<User> showListManager() throws SQLException;

	List<User> showListEmployee() throws SQLException;

	boolean updateManager() throws SQLException;
}
