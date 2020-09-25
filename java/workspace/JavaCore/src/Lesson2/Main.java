package Lesson2;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//---------------FOR
		int i=0;
		//int q=1;
/*		for(;i<100;i++)
		{
			if(i%2==1){
				int q=1;
				// System.out.println(i);
				System.out.printf("So le thu %d la %d \n",q,i);
				q++;
			}
		}
*/
		//---------------FOR--EACH
/*		float[] f = {1,2,3,4,5,2.678f};
		for(float a : f){
			System.out.println(a);
		}
*/
/*		i = 1;
		System.out.println(i);
		System.out.println(i++);
		System.out.println(i);
		i= 1;
		System.out.println(++i);
*/		
		System.out.printf("%.2f\n",1.234);
		System.out.printf("%3.2f\n",2.356);
		System.out.printf("%f\n",1.2345125);
/*
 * Lớp trả về số ngẫu nhiên
 * int x = random.nextInt(<max>);
 * System.out.println(x);
 */
		Random random = new Random();
		int x = random.nextInt(10) + 10;
		System.out.println(x);
		System.out.println("Nhập vào một số: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(s);
		
		
		//int age = sc.hasNextInt()? "Dung": "Sai";
		
		}
	}

