package Assignment3;
import java.time.LocalDate;
import java.util.Scanner;

public class Ex2 {
	static Scanner sc = new Scanner(System.in);
//Q1
	public static void RegAccount(){
		Account[] acc = new Account[5];
		for(int i = 0; i < 5; i++){
			System.out.println("Nhập email: ");
			acc[i+1].email = sc.nextLine();
			System.out.println("Nhập userName: ");
			acc[i+1].userName = sc.nextLine();
			System.out.println("Create Date: ");
			acc[i].createDate = LocalDate.now();
		}
	}
	public static void Main1(String[] argsss){
		RegAccount();
	}
}
