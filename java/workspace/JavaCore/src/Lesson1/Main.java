package Lesson1;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		int a= 12;
		long b = 2L;
		float c = 12.1f;
		double d = 23.5d;
		char e = 'a';
		char f = 97;
		//System.out.println(e + f);
		boolean g = true ;
//		System.out.println(g);
		
		int ab = 5/2;
		int ac = 5%2;
//		System.out.println(ac);
		float ad = 5f/2;
//		System.out.println(ad);
		
		boolean gg = !g;
//		System.out.println(gg);
		
		String str = "abcde fg â";
//		System.out.println(str);
		Date date = new Date();
//		System.out.println(date.toString());
		Gender nam = Gender.UNKNOW;
//		System.out.println(nam);
		
		int[] arr = {1,2,3,4,5};
		int[] arr1 = new int[3];
//		System.out.println(arr.length);
//		System.out.println(str.charAt(3));
		
		Person ng = new Person("Dzung",21);
//		System.out.println(ng.name +" " + ng.age);
		Person ng1 = new Person("Dzung",21);
		char var1 = 1;
		int var2 = 1;
// == So sánh địa chỉ ô nhớ
		float var3 = 1.0f;
		double var4 = 1d;
		boolean var5 = true;
//		System.out.println(var1 == var3);
		
		ng.eat();
		ng.eat("hàu");
// trả về thuộc tính của object-- mô tả Objects
		System.out.println(ng.toString());
// equal So sánh giá trị các thuộc tính với nhau
		System.out.println(ng.equals(ng1));
		
	
	}

}
