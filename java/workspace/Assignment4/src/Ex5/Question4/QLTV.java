package Ex5.Question4;

import java.util.Scanner;

import Ex5.Question1_2.CanBo;

public class QLTV {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Số sách cần nhập: ");
		int n = sc.nextInt();
		Sach[] dss = new Sach[n];
		for (int i = 0; i < n; i++) {
			Sach s = new Sach();
			s.input();
			dss[i] = s;
		}
		System.out.println("Tên sách cần tìm: ");
		String maTaiLieu = sc.nextLine();
		for (int i = 0; i < n; i++) {
			Sach s = new Sach();
			s = dss[i];
			if(s.check(maTaiLieu) == true)
				s.output();
		}
		System.out.println("Danh sách những sách nhập vào: ");
		for (int i = 0; i < n; i++) {
			Sach s = new Sach();
			s = dss[i];
			s.output();
		}
	}

}
