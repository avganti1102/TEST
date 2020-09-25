package Lesson1;

public class Person {
	String name;
	int age;	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void eat(){
		System.out.println(this.name + " Đang ăn");
	}
	
	public void eat(String foodName){
		System.out.println("Đang ăn " + foodName);
	}
	
	public boolean equals(Person other){
		boolean isSame = false;
		
		// == so sánh địa chỉ
		if(name == other.name && age == other.age){
			isSame = true;
		}
		return isSame;
	}
}
