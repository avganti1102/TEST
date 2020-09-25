package Ex2.Question4;

public class main {
	public static void main(String[] args) {
		MyMath a = new MyMath();
		System.out.println("Return int");
		System.out.println(a.sum(2,5));
		System.out.println("Return byte");
		System.out.println(a.sum(1, 6));
		System.out.println("Return float");
		System.out.println(a.sum(1.5f, 5.6f));
	}
}
