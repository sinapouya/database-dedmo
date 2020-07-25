/*create table person(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);
*/

insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10001,'SINA','TEHRAN',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10002,'MARYAM','TABRIZ',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10003,'MEHRI','TEHRAN',sysdate());
insert into PERSON(ID,NAME,LOCATION,BIRTH_DATE) values(10004,'ANGEL','TEHRAN',sysdate());

/*create table COURSE{
	id BIGINT not null,
	name varchar(255) not null
}
*/
--alter table COURSE add column CREATED_DATE timestamp;
--alter table COURSE add column LAST_UPDATED_DATE timestamp;

insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10001,'Simple jpa sample',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10002,'Simple spring sample',sysdate(),sysdate());
insert into COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) values(10003,'Simple spring boot sample',sysdate(),sysdate());

insert into STUDENT(ID,NAME) values(2001,'SINA');
insert into STUDENT(ID,NAME) values(2002,'MARYAM');
insert into STUDENT(ID,NAME) values(2003,'MEHRI');
insert into STUDENT(ID,NAME) values(2004,'ANGEL');

insert into PASSPORT(ID,number) values(4001,'S123456');
insert into PASSPORT(ID,number) values(4002,'M456759');
insert into PASSPORT(ID,number) values(4003,'M129873');
insert into PASSPORT(ID,number) values(4004,'A762678');

INSERT INTO REVIEW(ID,RATING,DESCRIPTION) 
	values(50001,'5','Greate Course');
INSERT INTO REVIEW(ID,RATING,DESCRIPTION) 
	values(50002,'4','Wonderfull Course');
INSERT INTO REVIEW(ID,RATING,DESCRIPTION) 
	values(50003,'4','Awesome Course');
INSERT INTO REVIEW(ID,RATING,DESCRIPTION) 
	values(50004,'5','Greate Course');	