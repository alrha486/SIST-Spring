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