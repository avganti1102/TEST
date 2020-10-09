package com.vti.final_exam.entity;

public class Employee extends User {
	private int projectID;
	private String proSkill;
	
	public Employee() {}

	public Employee(int id, String fullName, String email, String password,int projectID,String proSkill) {
		super(id, fullName, email, password);
		this.projectID = projectID;
		this.proSkill = proSkill;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	
	@Override
	public String toString() {
		return "Employee{" + "id=" + getId() + ", name='" + getFullName()+ ", email= " + getEmail() + ", projectID = " + getProjectID() +", ProSkill = " + getProSkill() + '\'' + '}';
	}
}