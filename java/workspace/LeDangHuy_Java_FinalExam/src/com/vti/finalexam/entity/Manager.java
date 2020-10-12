package com.vti.finalexam.entity;

public class Manager extends User{
	private int expInYear;

	public Manager(int id,String firstName, String lastName, String phone, String email, int expInYear) {
		super(id, firstName, lastName, phone, email);
		this.expInYear = expInYear;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
	
	
}
