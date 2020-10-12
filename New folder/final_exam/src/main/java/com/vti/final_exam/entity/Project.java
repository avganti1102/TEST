package com.vti.final_exam.entity;

public class Project {
	private int projectID;
	private int teamSize;
	Manager manager;
	Employee employee;
	
	public Project() {}
	
	public Project(int projectID,int teamSize,Manager manager,Employee employee) {
		this.projectID = projectID;
		this.teamSize = teamSize;
		this.manager = manager;
		this.employee = employee;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
