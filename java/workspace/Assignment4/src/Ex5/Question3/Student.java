package Ex5.Question3;

public class Student extends Person {
	private short id;

	public Student(String name,short id) {
		super(name);
		this.setId(id);
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}
	
}
