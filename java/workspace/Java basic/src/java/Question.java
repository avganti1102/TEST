package java;

import java.util.Date;

public class Question {
	
	String contentQ;			// Khai báo tên	
	int questionID	;			// Khai báo ID
	int categoryID	;
	int typeID;
	int creatorID;
	Date createDate;
	
	public  Question(String contentQ, int questionID) {
		super();
		this.contentQ = contentQ;
		this.questionID = questionID;
		
		
	}
	
	public void CategoryQuestion( int categoryID) {

		this.categoryID = categoryID;
	}

	public void TypeQuestion( int typeID) {

		System.out.println("Số TypeID là: " + typeID);
	}

	public void Group( int creatorID) {

		System.out.println("Số CreatorID là: " + creatorID);
	}
	
	public void Account( Date createDate) {

		this.createDate = createDate;
	}
}
