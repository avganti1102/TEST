package Lesson11;

public class Outer {
	private int x = 2;
	
	static class Inner {
		private static int y = 1;
	}
	
	public void String() {
		class Inner2{
			private int z = 3;
		}
	}
	
	
	public static void main(String[] args) {
		Outer a = new Outer();
		Outer.Inner b = new Inner();

		System.out.println(Outer.Inner.y);
//		System.out.println(a.x+ " " + b.y);
	}
}
