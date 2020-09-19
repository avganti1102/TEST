package Lesson4.Mobile;

public abstract class Mobile {
	protected String OS;
	private String name;
	public Mobile(String name){
		this.name = name;
	}
	
	public abstract void call();
	
	public void call(String phoneNumber){
		System.out.println("Calling to " + phoneNumber);
	}
}
