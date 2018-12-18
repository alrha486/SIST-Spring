create table member
(
	userid		varchar2(14) not null,
	name 		varchar2(20) not null,
	age			number(3) not null,
	gender		varchar2(10) not null,
	city			varchar2(20) not null,
	constraint member_userid_pk 	primary key(userid),
	constraint member_gender_ck 	check(gender IN('여성', '남성'))
)