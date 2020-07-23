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
insert into COURSE(ID,NAME) values(10001,'Simple jpa sample')