drop database if exists Test;
create database Test;
use Test;
create table if not exists Department
(
	DepartmentID tinyint auto_increment,
    DepartmentName nvarchar(50) not null unique key,
    primary key(DepartmentID)
);
create table if not exists `Position`
(
	PositionID tinyint auto_increment,
    PositionName enum('Dev','Test','Scrum Master','PM') unique key,
    primary key(PositionID)
);
create table if not exists `Account`
(
	AccountID tinyint auto_increment,
    Email nvarchar(30) not null unique key,
    Username varchar(30) not null unique key,
    Fullname nvarchar(30) not null,
    DepartmentID tinyint,
    PositionID tinyint,
    CreateDate datetime default now(),
    constraint fk_Account_DepartmentID foreign key(DepartmentID) references Department(DepartmentID),
    constraint fk_Account_PositionID foreign key(PositionID) references `Position`(PositionID),
    primary key (AccountID)
);
create table if not exists `Group`
(
	GroupID tinyint auto_increment,
    GroupName nvarchar(30) not null unique key,
    CreatorID char(10) not null,
    CreateDate datetime default now(),
    primary key(GroupID)
);
create table if not exists GroupAccount
(
	GroupID tinyint,
    AccountID tinyint,
    JoinDate datetime default now(),
    primary key(GroupID,AccountID),
    constraint fk_GroupAccount_GroupID foreign key(GroupID) references `Group`(GroupID),
    constraint fk_GroupAccount_AccountID foreign key(AccountID) references `Account`(AccountID)
);
create table if not exists TypeQuestion
(
	TypeID tinyint auto_increment,
    TypeName nvarchar(30) not null,
    primary key(TypeID)
);
create table if not exists CategoryQuestion
(
	CategoryID tinyint auto_increment,
    CategoryName varchar(30) not null not null,
    primary key(CategoryID)
);
create table if not exists Question
(
	QuestionID tinyint auto_increment,
    Content text not null,
    CategoryID tinyint,
    TypeID tinyint,
    CreatorID tinyint not null,
    CreateDate datetime default now(),
    constraint fk_Question_TypeID foreign key(TypeID) references TypeQuestion(TypeID),
    constraint fk_Question_CategoryID foreign key(CategoryID) references CategoryQuestion(CategoryID),
    primary key (QuestionID)
);
create table if not exists Answer
(
	AnswerID tinyint auto_increment,
    Content text not null,
    QuestionID tinyint,
    isCorrect enum('True','False'),
    constraint fk_Answer_QuestionID foreign key(QuestionID) references Question(QuestionID),
    primary key(AnswerID)
);
create table if not exists Exam
(
	ExamID tinyint auto_increment,
    `Code` char(10) not null,
    Title varchar(30),
    CategoryID tinyint,
    Duration tinyint not null,
    CreatorID tinyint not null,
    CreateDate datetime default now(),
    constraint fk_Exam_CategoryID foreign key(CategoryID) references CategoryQuestion(CategoryID),
    primary key(ExamID)
);
create table if not exists ExamQuestion
(
	ExamID tinyint,
    QuestionID tinyint,
    primary key(ExamID,QuestionID),
    constraint fk_ExamQuestion_ExamID foreign key(ExamID) references Exam(ExamID),
    constraint fk_ExamQuestion_QuestionID foreign key(QuestionID) references Question(QuestionID)
);
