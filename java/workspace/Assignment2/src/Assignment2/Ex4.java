package Assignment2;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Ex4 {
	
	public static int Q1(){
		Random rd = new Random();
		int x = rd.nextInt(100);
		System.out.println(x);
		return x;
	}
	public static double Q2(){
		Random rd = new Random();
		double x = rd.nextDouble();
		System.out.printf("%.5f\n",x);
		return x;
	}
	public static void Q3(){
		String[] clas = {"Dũng","Tân","Huy"};
		Random rd = new Random();
		int i = rd.nextInt(clas.length);
		System.out.println(clas[i]);
	}
	public static void Q4(){
		Random rd = new Random();
		int min = (int) LocalDate.of(1995,7, 24).toEpochDay();
		int max = (int) LocalDate.of(1995,12, 20).toEpochDay();
		long rdInt = rd.nextInt(max-min) + min;
		LocalDate rdDay = LocalDate.ofEpochDay(rdInt);
		System.out.println(rdDay);
	}
	public static void Q5(){
		Random rd = new Random();
		int min = (int) LocalDate.of(2019,9, 16).toEpochDay();
		int max = (int) LocalDate.of(2020,9, 16).toEpochDay();
		long rdInt = rd.nextInt(max-min) + min;
		LocalDate rdDay = LocalDate.ofEpochDay(rdInt);
		System.out.println(rdDay);
	}
	public static void Q6(){
		Random rd = new Random();
		int max = (int) LocalDate.of(2020,9, 16).toEpochDay();
		long rdInt = rd.nextInt(max);
		LocalDate rdDay = LocalDate.ofEpochDay(rdInt);
		System.out.println(rdDay);
	}
	public static void Q7(){
		Random rd = new Random();
		int x = rd.nextInt(1000);
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		
	}
}
