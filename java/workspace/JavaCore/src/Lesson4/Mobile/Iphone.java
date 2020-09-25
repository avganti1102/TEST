package Lesson4.Mobile;

import Lesson5.Mobile.IMobile;

public class Iphone extends Mobile implements IMobile{

	public Iphone(String name) {
		super(name);
		this.OS = "IOS";
	}
	
	@Override
	public void call() {
		System.out.println("Iphone!!");
	}

	@Override
	public void sms(String number,String sms) {
		System.out.println("Số: " + number + " nhắn đến bạn: " + sms);
	}

}
