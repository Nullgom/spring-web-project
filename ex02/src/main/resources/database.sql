CREATE SEQUENCE seq_board;

CREATE TABLE tbl_board (
    bno number(10, 0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdata date default sysdate,
    updatedate date default sysdate
);

ALTER TABLE tbl_board ADD CONSTRAINT pk_board PRIMARY KEY (bno);

INSERT INTO tbl_board (bno, title, content, writer)
VALUES (seq_board.nextval,  '텍스트 제목', '테스트 내용', 'user00');