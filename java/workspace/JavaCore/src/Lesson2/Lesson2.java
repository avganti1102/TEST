package Lesson2;


public class Lesson2 {
	//(condition) ? <value when condition = true) : (value when condition = false)
	// For -- each
	/*
	 * for(datatype : array){
	 * 	// statement
	 * }
	 */
	//------Datatype-Casting
	/*
	 * byte->short->int->long
	 * upcasting
	 * double -> float
	 * downCasting
	 */
	//Upcasting----Interger.MAX_VALUE
	public static void main(String[] args){
		int a = 110;
		long b = (long)a;
	//-------Wrapper
		String s = "12";
		//Tạo ra 1 class Integer bên trong gồm:
		//	-Một thuộc tính
		MyInteger my = new MyInteger(13);
		System.out.println(my.intValue());
		System.out.println(my.floatValue());
		System.out.println(my.valueOf1("11231126"));
		
		
	}
	
}
