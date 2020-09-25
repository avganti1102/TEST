package Lesson3.subPackage1;

import java.util.Random;
import java.util.Scanner;

public class subMain {
	public static void so(){
		Random rd = new Random();
		int hang = 100000;
		int numb = rd.nextInt(100000);
		while(hang >=1){
			System.out.print(numb/hang);
			numb %=hang;
			hang /=10;
		}
	}

	public static void main(String[] args) {
		//Person p = new Person();
		//System.out.println(p.id);
		so();
		Scanner sc = new Scanner(System.in);
		String str = "";
		String reverse2 = "";
		System.out.println("Nhập chuỗi");
		str = sc.nextLine();
		str.trim();
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse2 += str.charAt(i);
		}
		String[] word = reverse2.split(" ");
		System.out.println(word.length);
		for(String a : word){
			System.out.println(a);
		}
	}

}
