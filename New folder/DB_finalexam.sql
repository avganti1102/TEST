drop database final_exam;
create database if not exists final_exam;
use final_exam;
create table if not exists manager(
	ManagerID smallint not null primary key,
    fullName varchar(255) not null,
    Email varchar(100) not null unique,
    Passwd varchar(13) not null,
    ExpInYear tinyint not null,
    ProjectID tinyint
);

create table if not exists employee(
	EmployeeID smallint not null primary key,
    fullName varchar(255) not null,
    Email varchar(100) not null unique,
    Passwd varchar(13) not null,
    ProjectID tinyint,
    ProSkill varchar(10) not null
);

create table if not exists project(
	ProjectID tinyint not null primary key,
    teamSize smallint not null,
	ManagerID smallint,
    EmployeeID smallint,
    foreign key(ManagerID) references manager(ManagerID),
    foreign key(EmployeeID) references employee(EmployeeID)
);

ALTER TABLE employee
ADD CONSTRAINT fk_employee_ProjectID
FOREIGN KEY(projectID)
REFERENCES Project(ProjectID);

ALTER TABLE manager
ADD CONSTRAINT fk_manager_ProjectID
FOREIGN KEY(projectID)
REFERENCES Project(ProjectID);
    