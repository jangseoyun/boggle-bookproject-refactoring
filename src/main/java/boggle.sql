/* 책제목, 작성자닉네임, 서평내용, 좋아요한 수, 날짜 */
/*  1.해당 스타일과, 감정태그를 가진 서평(스타일이랑 이모션 조인
    2.중에서 책 no가 ***인 책중에서(책조인)
    3.유저넘버가 **인데 작성자 닉네임은 조인
    4.그리고 마지막으로 이 서평을 좋아요한 유저의 총 수(유저조인)<<이건 따로 서평하나에 나오게
    
*/

insert into review
values(seq_review_no.nextval, 2 , 9791189327156,
        1,'우리가 이름 붙여주지 않아도 이 세계에는 실재인 것들이 존재한다', sysdate);
        
        commit;

/****해당 스타일과 감정태그를 가진 서평*****/
select  r.review_no,
        s.style_no,
        e.emo_no,
        e.emo_name
from    review r, style s, emotion e
where   e.emo_no = s.emo_no
and     r.style_no = s.style_no;

/******중에서 책 no가 ***인!..******/
select  r.book_no,
        r.review_no,
        r.style_no,
        r.emo_name,
        b.book_title,
        r.nickname        
from   (select  r.review_no,
                r.book_no,
                s.style_no,
                e.emo_no,
                e.emo_name,
                r.user_no,
                u.nickname
        from   review r, style s, emotion e, users u
        where  e.emo_no = s.emo_no
        and    r.style_no = s.style_no
        and    r.user_no = u.user_no) r, books b
where   r.book_no = b.book_no 
and     b.book_no = 9791189327156;


/*******인것의 좋아요 수는!?!!********/
select  r.book_no,
        r.review_no,
        r.style_no,
        r.emo_name,
        b.book_title,
        r.nickname        
from   (select  r.review_no,
                r.book_no,
                s.style_no,
                e.emo_no,
                e.emo_name,
                r.user_no,
                u.nickname
        from   review r, style s, emotion e, users u
        where  e.emo_no = s.emo_no
        and    r.style_no = s.style_no
        and    r.user_no = u.user_no) r, books b
where   r.book_no = b.book_no 
and     b.book_no = 9791189327156;


select  r.book_no,
        r.review_no,
        r.style_no,
        r.emo_name,
        b.book_title,
        r.nickname,
        r.co
from   (select  r.review_no,
                r.book_no,
                s.style_no,
                e.emo_no,
                e.emo_name,
                r.user_no,
                u.nickname,
                ru.co
        from (select r.review_no,
                     ru.co,
                     r.book_no
              from (select review_no, count(review_no) co
                    from review_user
                    group by review_no) ru, review r
              where r.review_no = ru.review_no) ru, review r, style s, emotion e, users u
        where  e.emo_no = s.emo_no
        and    r.style_no = s.style_no
        and    r.user_no = u.user_no) r, books b
where   r.book_no = b.book_no 
and     b.book_no = 9791189327156;



select * from review_user;

select r.review_no,
        r.book_no,
        ru.co
from (select review_no, count(review_no) co
        from review_user
        group by review_no) ru, review r
where r.review_no = ru.review_no;




/****그 서평의 해당 스타일과 감정태그*****/
select  r.review_no,
        s.style_no,
        e.emo_no,
        e.emo_name
from    review r, style s, emotion e
where   e.emo_no = s.emo_no
and     r.style_no = s.style_no;

/******서평당 좋아요갯수(서평 넘버, 좋아요갯수, 북넘버) ********/
select r.review_no,
       ru.likecnt,
       r.book_no
from (select review_no, count(review_no) likecnt
      from review_user
      group by review_no) ru, review r
where r.review_no = ru.review_no;


/*****그스타일의 서평의 좋아요갯수****/
select r.review_no,
       ru.likecnt,
       r.style_no,
       r.emo_name,
       r.book_no
from   (select  r.review_no,
        s.style_no,
        e.emo_no,
        e.emo_name,
        r.book_no
        from    review r, style s, emotion e
        where   e.emo_no = s.emo_no
        and     r.style_no = s.style_no) r,(select review_no, count(review_no) likecnt
                                            from review_user
                                            group by review_no) ru
where r.review_no = ru.review_no;


/******중에서 책 no가 ***인!..******/
select  r.book_no,
        r.review_no,
        r.style_no,
        r.emo_name,
        b.book_title,
        r.likecnt,
        r.nickname
from   (select r.review_no,
                ru.likecnt,
                r.style_no,
                r.emo_name,
                r.book_no,
                r.nickname
        from   (select  r.review_no,
                        s.style_no,
                        e.emo_no,
                        e.emo_name,
                        r.book_no,
                        u.nickname
                from    review r, style s, emotion e, users u
                where   e.emo_no = s.emo_no
                and     r.style_no = s.style_no
                and     r.user_no = u.user_no) r,(select review_no, count(review_no) likecnt
                                                    from review_user
                                                    group by review_no) ru
        where r.review_no = ru.review_no) r, books b
where   r.book_no = b.book_no 
and     b.book_no = 9791189327156;


select  r.review_no,
        u.user_no,
        r.book_no,
        b.book_title,
        r.style_no,
        u.nickname,
        r.review_content,
        r.emo_name,
        r.review_date
from (select  r.review_no,
            r.book_no,
            r.review_content,
            r.review_date,
            s.style_no,
            e.emo_no,
            e.emo_name,
            r.user_no
        from    review r, style s, emotion e
        where   e.emo_no = s.emo_no
        and     r.style_no = s.style_no) r, users u, books b
where u.user_no = r.user_no
and b.book_no = r.book_no;








