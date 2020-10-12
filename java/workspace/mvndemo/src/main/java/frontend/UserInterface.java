package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.controller.DepartmentController;
import entity.Department;

public class UserInterface {
	public static void main(String[] args) {
		//Question 1
		try {
			showDepartmentList();
			insertDepartment("rocket06");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void insertDepartment(String name) throws FileNotFoundException, IOException, SQLException {
		DepartmentController dC = new DepartmentController();
		System.out.println(dC.insertDepartment(name));
	}

	private static void showDepartmentList() throws SQLException, FileNotFoundException, IOException {
		DepartmentController dC = new DepartmentController();
		List<Department> departments = dC.showDepartmentList();
		for (Department department : departments) {
			System.out.println(department.toString());
		}
	}
}
