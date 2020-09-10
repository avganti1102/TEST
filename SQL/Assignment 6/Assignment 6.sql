USE test;
-- 6,7,10,12,13
-- Q1: Tất cả các account thuộc phòng ban được nhập
DELIMITER $$
create procedure acc_of_department(in in_departmentName varchar(50))
	begin
		SELECT a.accountID, a.username, a.fullname
        from `account` a 
			inner join department d on a.departmentID = d.departmentID
		where d.departmentName = in_departmentName;
    end $$
DELIMITER ; 

call acc_of_department('SALE');

drop procedure acc_of_department;

-- Q2: In ra số lượng account trong mỗi group
DELIMITER $$
create procedure count_of_members()
	BEGIN
		select g.groupID,  ifnull(counta,'0')
		from `group` g
				left join (select groupID, count(accountID) as counta
							from groupaccount
							group by groupID) ga on g.groupID = ga.groupID
group by groupID;
    END $$
DELIMITER ;

call count_of_members;

drop procedure count_of_members;

-- Q3: Thống kê mỗi typeQ có bn Q đc tạo trong tháng hiện tại
DELIMITER $$
CREATE PROCEDURE countQ_of_typeQ(in in_month int)
	BEGIN
		select q.typeID, count(q.questionID) countQ
		from (select questionID, typeID
					from question
					where month(createDate) = in_month) q
		group by typeID;
    END $$
DELIMITER ;

call countQ_of_typeQ(month(now()));

drop procedure countQ_of_typeQ;

-- Q4: ID của typeQ có nhiều câu hỏi nhất
DELIMITER $$
CREATE PROCEDURE maxQ_of_typeQ(out out_typeID tinyint)
	BEGIN
		select typeID into out_typeID
		from(
		SELECT TYPEID , MAX(countT) max
		FROM( SELECT typeID, count(typeID) countT
				FROM question
				group by typeID) A) B; 
    END $$
DELIMITER ;

call maxQ_of_typeQ(@out_typeID);

drop procedure maxQ_of_typeQ;

-- Q5: Sử dụng store câu 4 để tìm ra tên type
DELIMITER $$
CREATE PROCEDURE typeName()
	BEGIN
    set @typeID = '';
		call maxQ_of_typeQ(@typeID);
        select typeName
        from typequestion
        where typeID = @typeID;
    END $$
DELIMITER ;

call typeName();

drop procedure typeName;
-- Q6: ```````````````````````````````````````````````````````
DELIMITER $$
CREATE PROCEDURE stringName(in in_string varchar(50))
	BEGIN
		select g.groupName
        from `group` g
        where g.groupName like concat('%',in_string,'%')
        union
        select a.userName
        from `account` a
        where userName like concat('%',in_string,'%');
    END $$
DELIMITER ;

call stringName('vti');

drop procedure stringName;

-- Q7: 
DELIMITER $$
CREATE PROCEDURE insert_account(in in_email varchar(50),in in_fullname varchar(50))
BEGIN
	DECLARE Username varchar(50) default substring_index(in_email,'@',1);
    DECLARE Department tinyint default 5;
    DECLARE PositionID tinyint default 1;
    DECLARE CreateDate datetime default now();
    
    insert into `Account` (email	,Username	,Fullname	,Department	,PositionID	,CreateDate)
    values				  (in_email	,Username	,in_fullname,DepartmentID,PositionID,CreateDate);
    
    SELECT * FROM `ACCOUNT`;
    END $$
DELIMITER ;


-- Q8: Nhập Essay or Mutiple_choice để thống kê câu hỏi có content dài nhất
DELIMITER $$
CREATE PROCEDURE maxContent(in in_typeName varchar(30),out out_typeID tinyint)
	BEGIN
		SELECT typeID into out_typeID
        FROM typequestion
        where typeName like in_typeName;
        select questionID, max(contentt)
        from (select questionID,typeID, length(content) contentt
				from question
                where typeID = out_typeID) A;
    END $$
DELIMITER ;

 set @content ='';
call maxContent('Essay',@out_typeID);
select @content;
drop procedure maxContent;

/* Cách 2: select questionID, max(contentt)
			from (select questionID,typeID, length(content) contentt
				from question
                where typeID in (SELECT typeID
								FROM typequestion
								where typeName like 'Essay')) A;
*/
-- Q9:
DELIMITER $$
CREATE PROCEDURE DEL_EXAM(in in_examID tinyint)
	BEGIN
		DELETE FROM EXAM
        WHERE examID = in_examID;
    END $$
DELIMITER ;

call del_exam();

drop procedure del_exam;

-- Q10:Tìm các exam được tạo từ 3 năm trước và xóa``````````````````````
DELIMITER $$
CREATE PROCEDURE find_and_del_exam(out out_date int)
	BEGIN
		select questionID into out_date
        from question
        where (year(now()) - 3) = year(CreateDate);
        call del_exam(@out_date);
        
        SELECT row_count(); -- Đếm số record đã bị ảnh hưởng bởi các câu truy vấn trc đấy(Delete, Update, Insert)
    END $$
DELIMITER ;

call find_and_del_exam(@out_date);

drop procedure find_and_del_exam;

-- Q11:
DELIMITER $$
CREATE PROCEDURE del_department(in in_departmentID tinyint)
	BEGIN
		UPDATE `account`
        set departmentID = '11'
        where departmentID = in_departmentID;
        DELETE FROM department
        where departmentID = in_departmentID;
    END $$
DELIMITER ;

call del_department();

drop procedure del_department;

-- Q12: 
DELIMITER $$
CREATE PROCEDURE EachMonth()
	BEGIN
		select EachMonth.`Month`, Count(QuestionID)
		from ( select 1 'Month'
			union select 2
			union select 3
			union select 4
			union select 5
			union select 6
			union select 7
			union select 8
			union select 9
			union select 10
			union select 11
			union select 12
			) EachMonth
			join Question on EachMonth.`Month` = Month(CreateDate)
			where Year(CreateDate) = Year(now())
			group by EachMonth.`Month`
			order by EachMonth.`Month` asc;
    END $$
DELIMITER ;
-- Q13:
DELIMITER $$
CREATE PROCEDURE Recent6month()
	BEGIN
		select Recent6month.`month`,count(QuestionID) count, if(COUNT(QUESTIONid) > 0,count(QuestionID),'Không có câu hỏi nào trong tháng')
        from(
			Select month(date_sub(Current_Date(),interval 0 month)) `Month`
            UNION
            Select month(date_sub(Current_Date(),interval 2 month))
            UNION
            Select month(date_sub(Current_Date(),interval 3 month))
            UNION
            Select month(date_sub(Current_Date(),interval 4 month))
            UNION
            Select month(date_sub(Current_Date(),interval 5 month))
			) as Recent6month
            left join Question on Recent6month.`Month` = Month(CreateDate)
            group by Recent6month.`Month`
            order by Recent6month.`Month` ASC;
	END $$
    
DELIMITER ;

call Recent6month();

drop procedure Recent6month;

delete from carorder
where orderID in 
(select orderID
from carorder
where `status` = 'Cancelled' and year(orderDate) <> year(now()));