package java;

import java.util.Date;

public class Exam {

	String code;
	String title;				// Khai báo tên	
	int examID			;		// Khai báo ID
	int categoryID	;
	int creatorID;
	int duration;
	Date createDate;
	
	public  Exam(String title, String code, int examID, int duration) {
		super();
		this.title = title;
		this.code = code;
		this.examID = examID;
		this.duration = duration;
	}
	
	
	public void CategoryQuestion( int categoryID) {

		System.out.println("Số CategoryID là: " + categoryID);
	}
	
	public void Group( int creatorID) {

		System.out.println("Số CreatorID là: " + creatorID);
	}
	public void Account( Date createDate) {

		this.createDate = createDate;
	}
	
}

