package com.vti.finalexam.frontend;

import java.sql.SQLException;

import com.vti.final_exam.utils.ScannerUtils;
import com.vti.finalexam.backend.presentationlayer.UserController;

public class Program {
	
	private static UserController userController;

	public static void main(String[] args) throws SQLException {
		
		userController = new UserController();
		
		int chon;
		do {
			System.out.println("\n*******************************************");
			System.out.println("**             Users system              **");
			System.out.println("*******************************************");
			System.out.println("**                                       **");
			System.out.println("**        1. Đăng nhập                   **");
			System.out.println("**        2. Đăng ký                     **");
			System.out.println("**        0. Thoát chương trình          **");
			System.out.println("**                                       **");
			System.out.println("*******************************************");
			System.out.println("**     Nhập lựa chọn của bạn             **");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(chon) {
			case 1:
				dangNhap();
				break;
			case 2:
				dangKy();
				break;
			case 0:
				System.out.println("Đã thoát chương trình thành công!");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while(chon != 0);
	}
	
	private static void dangNhap() throws SQLException{
		System.out.println("Nhap Email:");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap pass word:");
		String pass = ScannerUtils.inputString("Nhap lai!");
		if(userController.isUserExists(email, pass))
			System.out.println("Đăng nhập thành công!");
		else
			System.out.println("Email hoặc password không đúng. Kiểm tra lại!");
	}
	
	private static void dangKy() throws SQLException {
		boolean check = false;
		System.out.println("Nhap loai user muon tao (1-Manager ; 0-Employee): ");
		while (!check) {
			int loaiUser = ScannerUtils.inputInt("Nhap vao 1 so");
			if(loaiUser==1) {
				dangKyManager();
				check = true;
			}
			else if(loaiUser == 0) {
				dangKyEmployee();
				check = true;
			}
			else
				System.out.println("Khong co lua chon nay. nhap lai!");
		}
	}
	
	private static void dangKyManager() throws SQLException {
		System.out.println("Nhap FirstName:");
		String firstName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap LastName:");
		String lastName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Phone:");
		String phone = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Email:");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap pass word:");
		String pass = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap ExpInYear:");
		int expInYear = ScannerUtils.inputInt("Nhap lai!");
		userController.registerManager(firstName, lastName, phone, email, pass, expInYear);
	}
	
	private static void dangKyEmployee() throws SQLException {
		System.out.println("Nhap FirstName:");
		String firstName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap LastName:");
		String lastName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Phone:");
		String phone = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Email:");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap pass word:");
		String pass = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap projectName:");
		String projectName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap ProSkill:");
		String proSkill = ScannerUtils.inputString("Nhap lai!");
		userController.registerEmployee(firstName, lastName, phone, email, pass, projectName, proSkill);
	}

}
