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
import java.util.Scanner;
import entity.User;
import utils.JdbcUtils;

public class UserRepository implements IUserRepository {
	private JdbcUtils jdbcUtils;

	public UserRepository() throws IOException {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean insertManager() throws SQLException {
		Scanner sc = new Scanner(System.in);
		// Connect database
		Connection con = jdbcUtils.connect();
		// Create Statement
		String sql = "insert into usertest(firstName,lastName,phone,email,expInYear) values (?,?,?,?,?)";
		PreparedStatement prs = con.prepareStatement(sql);
		User us = new User();
		System.out.println("Nhap FirstName: ");
		us.setFirstName(sc.nextLine());
		System.out.println("Last Name: ");
		us.setLastName(sc.nextLine());
		System.out.println("Phone: ");
		us.setPhone(sc.nextLine());
		System.out.println("Email: ");
		us.setEmail(sc.nextLine());
		System.out.println("ExpInYear: ");
		us.setExpInYear(sc.nextShort());
		sc.nextLine();
		prs.setString(1, us.getFirstName());
		prs.setString(2, us.getLastName());
		prs.setString(3, us.getPhone());
		prs.setString(4, us.getEmail());
		prs.setShort(5, us.getExpInYear());
		int effectedRows = prs.executeUpdate();
		if (effectedRows == 1) {
			return true;
		} else
			return false;
	}

	@Override
	public List<User> showListManager() throws SQLException {
		List<User> managers = new ArrayList<>();
		Connection con = jdbcUtils.connect();
		//Create Statement
		Statement stm = con.createStatement();
		//Select
		String sql = "SELECT * FROM usertest where (projectName is null) and (proSkill is null)";
		ResultSet rs = stm.executeQuery(sql);
		//Add vao List<>
		while (rs.next()) {
			User manager = new User();
			manager.setFirstName(rs.getString("firstName"));
			manager.setLastName(rs.getString("lastName"));
			manager.setPhone(rs.getString("phone"));
			manager.setEmail(rs.getString("email"));
			manager.setExpInYear(rs.getShort("expInYear"));
			managers.add(manager);
			}
		//disconnect
		jdbcUtils.disconnect();
		return managers;
	}

	@Override
	public List<User> showListEmployee() throws SQLException {
		List<User> employees = new ArrayList<>();
		Connection con = jdbcUtils.connect();
		//Create Statement
		Statement stm = con.createStatement();
		//Select
		String sql = "SELECT * FROM usertest where expInYear is null";
		ResultSet rs = stm.executeQuery(sql);
		//Add vao List<>
		while (rs.next()) {
			User employee = new User();
			employee.setFirstName(rs.getString("firstName"));
			employee.setLastName(rs.getString("lastName"));
			employee.setPhone(rs.getString("phone"));
			employee.setEmail(rs.getString("email"));
			employee.setProjectName(rs.getString("projectName"));
			employee.setProSkill(rs.getString("proSkill"));
			employees.add(employee);
			}
		//disconnect
		jdbcUtils.disconnect();
		return employees;
	}

	@Override
	public boolean updateManager() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = jdbcUtils.connect();
		String sql = "update usertest"
				+ "		set ? = ?"
				+ "		where ? = ?";
		System.out.println("Update truong: ");
		String fieldName = sc.nextLine();
		System.out.println("Gia tri: ");
		String value = sc.nextLine();
		System.out.println("Condition: ");
		String conditionName = sc.nextLine();
		System.out.println("Value of condition: ");
		String conditionValue = sc.nextLine();
		
		PreparedStatement prs = con.prepareStatement(sql);
		prs.setString(1, fieldName);
		prs.setString(2, value);
		prs.setString(3, conditionName);
		prs.setString(4, conditionValue);
		int effectedRows = prs.executeUpdate();
		if(effectedRows == 1) {
			return true;
		}
		else
			return false;
	}

}
