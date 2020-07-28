--create table person(
--	id integer not null,
--	name varchar(255) not null,
--	location varchar(255),
--	birth_date timestamp,
--	primary key(id)
--);


insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10001,'SINA','TEHRAN',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10002,'MARYAM','TABRIZ',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10003,'MEHRI','TEHRAN',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10004,'ANGEL','TEHRAN',sysdate());

--create table COURSE{
--	id bigint not null,
--	name varchar(255) not null
--}
--
--alter table COURSE add column CREATED_DATE timestamp;
--alter table COURSE add column LAST_UPDATED_DATE timestamp;

insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10001,'Simple jpa sample',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10002,'Simple spring sample',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10003,'Simple spring boot sample',sysdate(),sysdate());

insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10004,'Dummy 1',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10005,'Dummy 2',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10006,'Dummy 3',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10007,'Dummy 4',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10008,'Dummy 5',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10009,'Dummy 6',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(100010,'Dummy 7',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(100011,'Dummy 8',sysdate(),sysdate());

insert into PASSPORT(ID,number) values(4001,'S123456');
insert into PASSPORT(ID,number) values(4002,'M456759');
insert into PASSPORT(ID,number) values(4003,'M129873');
insert into PASSPORT(ID,number) values(4004,'A762678');

insert into STUDENT(ID,NAME,PASSPORT_ID) values(2001,'SINA',4001);
insert into STUDENT(ID,NAME,PASSPORT_ID) values(2002,'MARYAM',4002);
insert into STUDENT(ID,NAME,PASSPORT_ID) values(2003,'MEHRI',4003);
insert into STUDENT(ID,NAME,PASSPORT_ID) values(2004,'ANGEL',4004);



INSERT INTO REVIEW(ID,RATING,DESCRIPTION,course_id) 
	values(50001,'5','Greate Course',10001);
INSERT INTO REVIEW(ID,RATING,DESCRIPTION,course_id) 
	values(50002,'4','Wonderfull Course',10001);
INSERT INTO REVIEW(ID,RATING,DESCRIPTION,course_id) 
	values(50003,'4','Awesome Course',10003);
INSERT INTO REVIEW(ID,RATING,DESCRIPTION,course_id) 
	values(50004,'5','Greate Course',10003);	
	
	
insert into student_course(student_id,course_id) values (2001,10002);	
insert into student_course(student_id,course_id) values (2001,10002);
insert into student_course(student_id,course_id) values (2001,10002);
insert into student_course(student_id,course_id) values (2004,10003);

