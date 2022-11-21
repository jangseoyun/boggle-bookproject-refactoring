--#review_user 서평을 좋아요한 사용자
--##############[review_user 테이블]#############--


/********** 시퀀스 삭제**********/
drop sequence seq_review_user_no;

/********** 시퀀스 생성 **********/
create sequence seq_review_user_no
increment by 1
start with 1
nocache;

/********** insert **********/
insert into review_user
values(seq_review_user_no.nextval, 1, 1, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 1, 3, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 1, 20, sysdate );

insert into review_user
values(seq_review_user_no.nextval, 2, 2, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 2, 6, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 2, 18, sysdate );

insert into review_user
values(seq_review_user_no.nextval, 3, 3, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 3, 4, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 3, 15, sysdate );

insert into review_user
values(seq_review_user_no.nextval, 4, 5, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 4, 10, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 4, 11, sysdate );

insert into review_user
values(seq_review_user_no.nextval, 5, 6, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 5, 12, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 5, 19, sysdate );

insert into review_user
values(seq_review_user_no.nextval, 6, 7, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 6, 8, sysdate );
insert into review_user
values(seq_review_user_no.nextval, 6, 13, sysdate );


/*1번서평 좋아요한 사용자 추가*/
insert into review_user
values(SEQ_REVIEW_USER_NO.nextval, 3, 1, sysdate);
insert into review_user
values(SEQ_REVIEW_USER_NO.nextval, 2, 1, sysdate);
insert into review_user
values(SEQ_REVIEW_USER_NO.nextval, 4, 1, sysdate);

/********** select **********/
select *
from review_user;

commit;

/********** 좋아요 취소 **********/
delete from review_user
where review_no = 1
and user_no = 1;