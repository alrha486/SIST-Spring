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

--- 전체조회 프로시저
create or replace procedure sp_member_select_all
(
    rec_members      out     sys_refcursor
)as
begin
    open rec_members for 
    select userid,name,age,gender,city
    from member order by userid desc;
end;


--- 회원입력 프로시저
create or replace procedure sp_member_insert
(
    v_userid    in      member.userid%type,
    v_name      in      member.name%type,
    v_age       in      member.age%type,
    v_gender    in      member.gender%type,
    v_city      in      member.city%type
)
is 
begin
    insert into member(userid,name,age,gender,city)
    values(v_userid, v_name, v_age, v_gender, v_city);
    commit;
end;

--- 한명
create or replace procedure sp_member_select_one
(
    v_userid    in      member.userid%type,
    rec_member  out     SYS_REFCURSOR
)
AS 
begin
open rec_member for
    select *
    from member 
    where userid = v_userid;
end;