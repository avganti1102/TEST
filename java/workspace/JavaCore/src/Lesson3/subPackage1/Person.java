package Lesson3.subPackage1;

public class Person {
	private String address;
	protected int id;
	public String name;
	int age;

	// Person vừa là object vừa là kiểu dữ liệu
	public Person() {
		this.name = "";
		this.age = 0;
	}

	public Person(String name) {
		this.name = name;
		this.age = 0;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		while (age < 0){
			System.out.println("Tuổi phải lớn hơn 0");
			break;
		}
			this.age = age;
	}

}
