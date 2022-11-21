--테이블 삭제
drop table users;

--시퀀스 삭제
drop sequence seq_user_no;

--테이블생성
CREATE TABLE users (
	user_no NUMBER NOT NULL, /* user_no */
	user_name VARCHAR2(100), /* 이름 */
	nickname VARCHAR2(200), /* 닉네임 */
	email VARCHAR2(500) UNIQUE, /* 이메일 */
	password VARCHAR2(100), /* 비밀번호 */
	user_profile VARCHAR2(500), /* 프로필 이미지 경로 */
	join_date date, /* 가입날짜 */
    PRIMARY KEY(user_no)
);

--시퀀스 생성
CREATE SEQUENCE seq_user_no
INCREMENT BY 1 
START WITH 1 ;

--insert
insert into users
values(seq_user_no.nextval, '황일영', '가짜정우성', '1young@naver.com', '1234', '@@@@@', sysdate);
insert into users
values(seq_user_no.nextval, '김지연', '니모먹는스폰지밥', 'delay516@naver.com', '1234', '@@@@@', sysdate);
insert into users
values(seq_user_no.nextval, '이영림', '구직중입니다', 'rm1113@naver.com', '1234', '@@@@@', sysdate);
insert into users
values(seq_user_no.nextval, '장서윤', '신호는우엥', 'westyoon501@naver.com', '1234', '@@@@@', sysdate);
insert into users
values(seq_user_no.nextval, '황인경', '후추가득스테이크', 'inKe831@naver.com', '1234', '@@@@@', sysdate);
insert into users
values(seq_user_no.nextval, '황희원', '마크부인캐나다인', 'hee1@naver.com', '1234', '@@@@@', sysdate);



update users set user_profile = 'https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202201/04/9d10eb85-214f-4dd2-a2f7-c3ae80387913.jpg'
where user_no = 1;
update users set user_profile = 'https://ww.namu.la/s/bd52223e4d1f11fcc4c7f6506bf3321b26579bf118db6c1ca20492b9af4228a414edd25f1006baace220e4ca771288e0f38d6cbf253ae4e9d39aaf4b881600b0d65e518e7d94891837ee9a0c6a723aac0f4d2b7bf4a65b36bd1fe636aa49c632'
where user_no = 2;
update users set user_profile = 'https://pbs.twimg.com/media/Ewva3yqVoAAorHA.jpg'
where user_no = 3;
update users set user_profile = 'https://mblogthumb-phinf.pstatic.net/MjAxOTAyMThfMjg2/MDAxNTUwNDU1NDM0OTM0.3hZ14ZKCNfOzeeZHVghxdpyX_8p2GV0B9dbry4phXwwg.ik9Pp55K8tkx-3okJ7TlYlGT4iNL6RZmyNf5PriSnSMg.PNG.green-solar/image.png?type=w800'
where user_no = 4;
update users set user_profile = 'http://file3.instiz.net/data/cached_img/upload/2019/04/29/1/931ae4250ebf5040df54dc8e78492926.jpg'
where user_no = 5;
update users set user_profile = 'https://pbs.twimg.com/media/EUMmqQkU4AAZ6Oj.jpg'
where user_no = 6;

       
commit;   

select *
from users;
              
select  user_no,
        user_name,
        nickname,
        email,
        password,
        user_profile,
        to_char(join_date,'yyyy-mm-dd hh:mi:ss') join_date
from users;


--update문
update users 
set nickname = '제발채용해주세요'
where user_no = 3;


--delete문
delete from users
where no = 4;

