CREATE SEQUENCE seq_board;
--DROP SEQUENCE seq_board;

CREATE TABLE board(
    board_no NUMBER(10),
    writer VARCHAR2(20) NOT NULL,
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000),
    view_count NUMBER(10) DEFAULT 0,
    reg_date DATE DEFAULT SYSDATE,
    CONSTRAINT pk_board PRIMARY KEY (board_no)
);

--DROP TABLE board;

SELECT * FROM board;

-- 더미데이터
INSERT INTO board (board_no, writer, title, content)
VALUES (SEQ_BOARD.nextval, '김기준', '가입인사올립니다.', '안녕하세요~~~');

COMMIT;
