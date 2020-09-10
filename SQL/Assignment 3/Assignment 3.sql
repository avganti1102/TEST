use test;
-- Q_1

-- Q_2
SELECT * FROM department;

-- Q_3
SELECT DepartmentID
FROM department
WHERE DepartmentID = 'Sale';

-- Q_4
SELECT * 
FROM `Account`
order by length(FullName) desc
limit 5;

-- Q_5
select *
from `account`
where departmentID = 3 and length(FullName) = (select max(length(FullName)) from `account` where departmentID = 3);

-- Q_6
SELECT GroupName
FROM `Group`
WHERE CreateDate < '2019-12-20';

-- Q_7
SELECT q.QuestionID , count(AnswerID)
FROM Question q inner join Answer a on q.QuestionID = a.QuestionID
group by QuestionID
having count(answerID) >=4;

-- Q_8
SELECT e.ExamID, e.Duration, e.CreateDate
FROM Exam e
WHERE Duration >= '60';

-- Q_9
select groupID, groupName
FROM `group`
order by now() - CreateDate
limit 5;

-- Q_10
SELECT d.DepartmentID, count(AccountID)
FROM Department d inner join `Account` ac on d.departmentID = ac.DepartmentID
WHERE d.DepartmentID = 2;

-- Q_11
SELECT *
FROM `Account`
WHERE Fullname like 'D%o';

-- Q_12
DELETE FROM Exam
where CreateDate < '2019-12-20';

-- Q_13
DELETE FROM Question
WHERE content = 'câu hỏi%';

-- Q_14
UPDATE `Account`
SET 
	Email = 'loc.nguyenba@vti.com.vn',
    Fullname = 'Nguyễn Bá Lộc'
WHERE
	AccountID = '5';

-- Q_15
UPDATE Groupaccount
SET
	GroupID = '4'
WHERE AccountID = '5';
