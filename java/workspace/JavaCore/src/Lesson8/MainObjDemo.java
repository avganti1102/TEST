package Lesson8;
// In ra file
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainObjDemo {
	public static void main(String[] args){
		String filePath = "F:\\test1.txt" ; 
		OutputStream ops = null;
		ObjectOutputStream oos = null;
		try {
			ops = new FileOutputStream(filePath);
			ButLong bl = new ButLong(true);
			oos = new ObjectOutputStream(ops);
			oos.writeObject(bl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		finally {
			try {
				ops.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
				}
			}
	}
}
