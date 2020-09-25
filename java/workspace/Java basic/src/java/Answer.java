package java;

import java.util.Date;

public class Answer {
	
	String contentA;			// Khai báo tên	
	int questionID	;			// Khai báo ID
	int answerID	;
	boolean isCorrect;
	
	public  Answer(String contentA, int answerID, boolean isCorrect) {
		super();
		this.contentA = contentA;
		this.answerID = answerID;
		this.isCorrect = isCorrect;
		
	}
	public void Question(int questionID) {
	
	this.questionID = questionID;
	}
	
}
