package backend.repository;

import java.sql.SQLException;
import java.util.List;

import entity.Department;

public interface IDepartmentRepository {
	List<Department> showDepartmentList() throws SQLException;
	public boolean insertDepartment(String name) throws SQLException;
}