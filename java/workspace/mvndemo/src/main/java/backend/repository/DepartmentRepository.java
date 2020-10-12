package backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import utils.JdbcUtils;

public class DepartmentRepository implements IDepartmentRepository{
	private JdbcUtils jdbcUtils;
	
	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}
	
	@Override
	public List<Department> showDepartmentList() throws SQLException {
		List<Department> departments = new ArrayList<>();
		Connection con = jdbcUtils.connect();
		//Create Statement
		Statement stm = con.createStatement();
		//Select
		String sql = "SELECT * FROM Department";
		ResultSet resultSet = stm.executeQuery(sql);
		//Add vao List<>
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));
			departments.add(department);
			}
		//disconnect
		jdbcUtils.disconnect();
		return departments;
	}

	@Override
	public boolean insertDepartment(String name) throws SQLException {
			//Connect DB
			Connection con = jdbcUtils.connect();
			// Create a statement object
			String sql = "insert into department (departmentName) values (?)";
			PreparedStatement preStm = con.prepareStatement(sql);
			preStm.setString(1, name);
			int effecedRows = preStm.executeUpdate();
			 if(effecedRows == 1) {
				 return true;
			 }
			 else {
				 return false;
			 }
	}
}
