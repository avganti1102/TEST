package Lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main1 {
	public static void main(String[] args) {
		File file = new File("F:\\VTI");
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//Cú pháp có thể có lỗi
	}
}
