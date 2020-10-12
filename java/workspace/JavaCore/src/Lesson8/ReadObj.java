package Lesson8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ReadObj {
	public static void main(String[] args) {
		InputStream is = null;
		ObjectInputStream ois = null;
	try {
		is = new FileInputStream("F:\\test1.txt");
		ois = new ObjectInputStream(is);
		ButLong bl = (ButLong) ois.readObject();
		System.out.println(bl.isMuc());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
