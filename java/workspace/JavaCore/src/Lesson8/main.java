package Lesson8;

import java.io.File;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException {
		//Trỏ đến 1 file
/*
		String filePath = "F:\\test" ;	//Tạo đường dẫn file / folder
		File file = new File(filePath); //tạo con trỏ đến file
		System.out.println(file.exists()); // Ktra đường dẫn đúng hay k
		System.out.println(file.isFile()); // Ktra xem có phải file không
		// absolute Path: đường dẫn tuyệt đối (F:\\test)
		// relative Path: đường dẫn tương đối (/test)
		System.out.println(file.isAbsolute());
		
		String filePath1 = "F:\\aaasd\\a2\\a3.txt" ;
		File file1 = new File(filePath1);
		System.out.println(file1.exists());
		
		file1.createNewFile(); // Tạo file mới từ đường dẫn mới add, ghi đè lên file cũ khi đã tồn tại
		file1.mkdir(); //Tạo thư mục con theo đường dẫn khi và chỉ khi thư mục cha đã tồn tại
*/		
		String filePath2 = "F:\\" ;
		File file2 = new File(filePath2);
//		file2.mkdirs();//  Tạo thư mục theo đường dẫn, ghi đè lên những thư mục đã tồn tại
		
		String[] a = file2.list();		//Hiện tên các file hoặc thư mục trong đường dẫn
		for(String fileName : a) {
			System.out.println(fileName);
			
		}
	}
}
