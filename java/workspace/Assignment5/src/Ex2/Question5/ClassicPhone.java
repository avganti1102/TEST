package Ex2.Question5;

public class ClassicPhone extends Phone {
	@Override
	public void call() {
		super.call();
	}
	@Override
	public void hear() {
		// TODO Auto-generated method stub
		super.hear();
	}
	@Override
	public void sendSMS() {
		// TODO Auto-generated method stub
		super.sendSMS();
	}
	@Override
	public void receiveSMS() {
		// TODO Auto-generated method stub
		super.receiveSMS();
	}
	
	public void radio(){
		System.out.println("Có thể nghe Radio");
	}
	@Override
	public void attackBadGuy() {
		System.out.println("Điện thoại cổ điển -- Tấn công!!");
	}
}
