package Ex4;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Student {
	private String name;
	private short id;
	private String homeTown;
	private byte score;
	
	public Student(String name, String homeTown){
		this.name = name;
		this.homeTown = homeTown;
		this.score = 0;
	}

	public void setScore(byte score) {
		this.score = score;
	}
	
	public void scorePlus(byte plus){
		this.score += plus;
	}
	
	public void info(){
		System.out.println("Tên sv: " + this.name);
		System.out.println("Quê quán: "+ this.homeTown);
		if(this.score < 4){
			System.out.println("Yếu");
		}
		else if(this.score < 6){
			System.out.println("Trung bình");
		}
		else if(this.score < 8){
			System.out.println("Khá");
		}
		else
			System.out.println("Giỏi");
	}
}
