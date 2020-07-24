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