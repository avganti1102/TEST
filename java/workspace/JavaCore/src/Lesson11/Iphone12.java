package Lesson11;

import java.net.FileNameMap;

public class Iphone12 {
	private static int count = 0;
	private int stt;
	public Iphone12() {
		count++;
		stt = count;
		System.out.println(count);
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Da vut Iphone12 : " + stt);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Iphone12();
			System.gc();
		}
	}
}
