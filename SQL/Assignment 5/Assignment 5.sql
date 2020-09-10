use test;
-- Q1: Danh sách nhân viên thuộc phòng ban SALE
select username, Fullname
from `account`
where departmentID = (select departmentID from department where departmentName = 'SALE');

-- Q2: Thông tin account tham gia vào nhiều group nhất
-- chữa C1:
select a.*,count(a.accountID) quantityGR
from `account` a
join groupaccount g on a.accountID = g.accountID
group by a.accountID
having quantityGR = (	select max(ac.quantityGR)
						from (	select `accountID`, count(accountID) quantityGR
								from groupaccount
								group by accountID) ac
					);
-- chữa C2:
-- Tạo CTE
WITH Cte_test as ( select accountID, count(accountID) quantityGR
								from groupaccount
								group by accountID)
SELECT accountID, quantityGr
FROM Cte_test
where quantityGr = ( select max(quantityGR)
					from Cte_test);
                    
-- Q3: Câu hỏi có những content quá 300 từ và xóa nó đi
delete from question
where questionID in
			(select questionID
			from question
			where length(content) > 300);

-- Q4: Danh sách các phòng ban có chứa nhiều nhân viên nhất
select d.*,count(d.departmentID) quantity
from department d
join `account` a on a.departmentID = d.departmentID
group by d.departmentID
having quantity = (	select max(dc.quantity)
						from (	select count(departmentID) quantity
								from `account`
								group by departmentID) dc
                                );
                
-- Q5: Tất cả các câu hỏi do user họ Nguyễn tạo

select q.questionID, q.Content
from question q inner join `account` a on q.CreatorID = a.AccountID
where q.CreatorID in (select AccountID
					from `account` 
                    where Fullname like 'Nguyen%');


