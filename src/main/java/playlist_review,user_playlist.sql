//////////////////////
// playlist_review
//////////////////////

create sequence seq_playlist_review_no
start with 1 increment by 1;

insert into playlist_review
values(seq_playlist_review_no.nextval, 1, 1, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 1, 2, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 1, 3, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 1, 4, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 1, 5, sysdate);

insert into playlist_review
values(seq_playlist_review_no.nextval, 2, 6, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 2, 7, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 2, 8, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 2, 9, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 2, 10, sysdate);

insert into playlist_review
values(seq_playlist_review_no.nextval, 3, 11, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 3, 12, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 3, 13, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 3, 14, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 3, 15, sysdate);

insert into playlist_review
values(seq_playlist_review_no.nextval, 4, 16, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 4, 17, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 4, 18, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 4, 19, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 4, 20, sysdate);

insert into playlist_review
values(seq_playlist_review_no.nextval, 5, 1, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 5, 2, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 5, 3, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 5, 4, sysdate);
insert into playlist_review
values(seq_playlist_review_no.nextval, 5, 5, sysdate);

select * from playlist_review;

/////////////////////
// user_playlist
/////////////////////

select * from users;
select * from playlist;

create sequence seq_user_playlist_no
start with 1 increment by 1;

insert into user_playlist 
values(seq_user_playlist_no.nextval, 1, 1);
insert into user_playlist
values(seq_user_playlist_no.nextval, 1, 2);
insert into user_playlist 
values(seq_user_playlist_no.nextval, 1, 3);

insert into user_playlist 
values(seq_user_playlist_no.nextval, 2, 3);
insert into user_playlist
values(seq_user_playlist_no.nextval, 2, 4);
insert into user_playlist
values(seq_user_playlist_no.nextval, 2, 5);

insert into user_playlist 
values(seq_user_playlist_no.nextval, 3, 1);
insert into user_playlist
values(seq_user_playlist_no.nextval, 3, 2);
insert into user_playlist 
values(seq_user_playlist_no.nextval, 3, 3);

insert into user_playlist 
values(seq_user_playlist_no.nextval, 4, 3);
insert into user_playlist
values(seq_user_playlist_no.nextval, 4, 4);
insert into user_playlist
values(seq_user_playlist_no.nextval, 4, 5);

insert into user_playlist 
values(seq_user_playlist_no.nextval, 5, 1);
insert into user_playlist
values(seq_user_playlist_no.nextval, 5, 2);
insert into user_playlist 
values(seq_user_playlist_no.nextval, 5, 3);
insert into user_playlist
values(seq_user_playlist_no.nextval, 5, 4);
insert into user_playlist
values(seq_user_playlist_no.nextval, 5, 5);

insert into user_playlist 
values(seq_user_playlist_no.nextval, 6, 1);
insert into user_playlist
values(seq_user_playlist_no.nextval, 6, 2);
insert into user_playlist 
values(seq_user_playlist_no.nextval, 6, 3);
insert into user_playlist
values(seq_user_playlist_no.nextval, 6, 4);
insert into user_playlist
values(seq_user_playlist_no.nextval, 6, 5);

select * from user_playlist;