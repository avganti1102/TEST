package Lesson8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStream {
	/*	---------IOStream----
	 * -- InputStream 
	 * +
	 * -- OutputStram 
	 */
	//FileInputStream : Đọc vào 1 file bth/ file trong hệ thống/ file trên server (File thông thường)
	//FileReader : thường dùng cho file text
	//FileWriter : thường dùng cho file text
	public static void main(String[] args){
		FileInputStream fis = null;
	//FileOutputStream : Ghi vào 1 file
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("F:\\test.txt"); // Tạo 1... cái gì đấy để đọc dữ liệu từ file
			fos = new FileOutputStream("F:\\test_copy.txt");
			int c;
			try {
				while((c = fis.read()) != -1){
					System.out.print((char) c);
					fos.write((char) c); // FOS
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(fis != null)
				try {
					fis.close();
					fos.close();// FOS
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
