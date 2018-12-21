sqlplus /nolog
conn SYS as sysdba
ALTER SESSION SET "_ORACLE_SCRIPT"=true;



CREATE USER bbs
	IDENTIFIED BY bbs
	DEFAULT TABLESPACE USERS
	TEMPORARY TABLESPACE temp;


	
ALTER USER bbs DEFAULT TABLESPACE USERS
	QUOTA UNLIMITED ON users;
	GRANT resource, connect TO bbs;



CREATE SEQUENCE seq_board_idx
MAXVALUE 9999;



CREATE TABLE Board
(
	idx NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	email VARCHAR2(100),
	title VARCHAR2(100) NOT NULL,
	contents VARCHAR2(2000) NOT NULL,
	writedate DATE DEFAULT SYSDATE,
	readnum NUMBER(4) DEFAULT 0,
	grp NUMBER(4) NOT NULL,
	lev NUMBER(2) DEFAULT 0,
	step NUMBER(2) DEFAULT 0,
	CONSTRAINT board_idx_pk PRIMARY KEY(idx)
);
 
 

CREATE OR REPLACE PROCEDURE sp_board_insert
(
    v_name         IN       Board.name%TYPE,
    v_email         IN       Board.email%TYPE,
    v_title         IN       Board.title%TYPE,
    v_contents         IN       Board.contents%TYPE
)
IS
BEGIN
    INSERT INTO Board(idx, name, email, title, contents, grp)
    VALUES (SEQ_BOARD_IDX.nextval, v_name, v_email, v_title, v_contents, SEQ_BOARD_IDX.currval);
    COMMIT;
END;



CREATE OR REPLACE PROCEDURE sp_board_select_all
(
   rec_board        OUT      SYS_REFCURSOR
)
AS
BEGIN
   open rec_board for
   select idx, name, email, title, TO_CHAR(writedate,'YYYY-MM-DD') AS writedate, readnum, grp, lev, step
   from board order by grp desc, step asc;
END;


CREATE OR REPLACE PROCEDURE sp_board_select_one
(
    v_idx               in          board.idx%type,
   rec_board        OUT      SYS_REFCURSOR
)
AS
BEGIN
   open rec_board for
   select idx, name, email, title, contents, TO_CHAR(writedate,'YYYY-MM-DD') AS writedate, readnum, grp, lev, step
   from board
   where idx = v_idx;
END;


CREATE OR REPLACE PROCEDURE sp_board_delete
(
    v_idx               in          board.idx%type
)
is
BEGIN
   delete from board
   where idx = v_idx;
   commit;
END;

CREATE OR REPLACE PROCEDURE sp_board_update
(
    v_email                in          board.email%type,
    v_title                 in          board.title%type,
    v_contents          in          board.contents%type,
    v_idx                   in          board.idx%type
)
is
BEGIN
   update board
   set email = v_email, title = v_title, contents = v_contents
   where idx = v_idx;
   commit;
END;