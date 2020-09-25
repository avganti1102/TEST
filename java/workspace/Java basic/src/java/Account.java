package java;

import java.util.Date;

public class Account {

	String userName;
	String email;
	String fullName;	// Khai báo tên	
	int accountID;
	int departmentID;
	int positionID;		// Khai báo ID
	Date createDate;
	Group[] groups;
	
	public Account(String userName, int accountID, String fullName,String email) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.accountID = accountID;
		this.email	=	email;
		
	}
	
	public Account( Date createDate) {

		this.createDate = createDate;
	}
	
	public void Department( int departmentID) {

		this.departmentID = departmentID;
	}
	
	public void positionID( int positionID) {

		this.positionID = positionID;
	}
}
