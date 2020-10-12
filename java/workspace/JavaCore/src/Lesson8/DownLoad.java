package Lesson8;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownLoad {
	public static void main(String[] args) {
		String filePath = "https://vieclam123.vn/ckfinder/userfiles/images/chu-vi-la-do-dai-cua-duong-thang-bao-quanh-mat-phang.jpg";
		try {
			URL img = new URL(filePath);	
			try {
				BufferedInputStream buf = new BufferedInputStream(img.openStream()); //img.openStream: Là 1 InputStream
								//buf : đọc vào ctr img.openStream (đọc được những file lớn)
				FileOutputStream fos = new FileOutputStream("F:\\abc.jpg");
				byte[] dataBuffer = new byte[1024];
				int numbOfByte = 0;
				while((numbOfByte = buf.read(dataBuffer/* ,0,1024 */)) != -1) { // .read(dataBuffer) trả về số byte mảng thu được
					System.out.println(numbOfByte);
					fos.write(dataBuffer,0,numbOfByte);
				}
				img.openStream().close();
				buf.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
}
