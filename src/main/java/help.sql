--테이블 삭제
drop table help;

--시퀀스 삭제
drop sequence seq_help_no;

--테이블생성
CREATE TABLE help (
    no number,
    title varchar2(500) NOT NULL,
    content varchar2(4000),
    reg_date date NOT NULL,
    user_no number NOT NULL,
    FOREIGN KEY (user_no) REFERENCES users(user_no),
    PRIMARY KEY(no)
);
    
--시퀀스 생성
CREATE SEQUENCE seq_help_no
INCREMENT BY 1 
START WITH 1;

--insert
insert into help
values(seq_help_no.nextval, '이 페이지 어찌 쓰는건가요?', '페이지가 조금 생소한데 이쁘군요. 활용 방법 문의드립니돠.', sysdate, 1);
insert into help
values(seq_help_no.nextval, '제목222', '내용222', sysdate, 2);
insert into help
values(seq_help_no.nextval, '제목333', '내용333', sysdate, 3);
insert into help
values(seq_help_no.nextval, '제목444', '내용444', sysdate, 4);
insert into help
values(seq_help_no.nextval, '제목555', '내용555', sysdate, 5);
insert into help
values(seq_help_no.nextval, '제목666', '내용666', sysdate, 6);
       
commit;       
       


--delete문
delete from help
where no = 4;     

select *
from users;

select *
from help;

commit;  