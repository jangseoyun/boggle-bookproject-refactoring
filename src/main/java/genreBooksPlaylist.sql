//////////////////////////
// genre
//////////////////////////
insert into genre
values('987', '과학');
insert into genre
values('55889', '에세이');
insert into genre
values('1', '소설/시/희곡');
insert into genre
values('656', '인문학');
insert into genre
values('2105', '고전');
insert into genre
values('517', '예술/대중문화');
insert into genre
values('336', '자기계발');
insert into genre
values('1108', '어린이');
insert into genre
values('38404', '사회과학');

--#전체 출력--
select *
from genre;

//////////////////
// books
//////////////////

--#컬럼 추가(이미지 커버 url)
alter table books add(cover_url varchar2(500));

--#데이터 삭제
delete from books;

--#데이터 추가
insert into books
values(9791189327156, '물고기는 존재하지 않는다', '룰루 밀러', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=284657330', 987, 'https://image.aladin.co.kr/product/28465/73/cover500/k092835920_1.jpg');
insert into books
values(9791197037153, '작은 별이지만 빛나고 있어', '소윤', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=280389330', 55889, 'https://image.aladin.co.kr/product/28038/93/cover500/k012734230_1.jpg');
insert into books
values(9791166686603, '다섯 번째 감각', '김보영', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=287367114', 1, 'https://image.aladin.co.kr/product/28736/71/cover500/k442836780_1.jpg');
insert into books
values(9791160804751, '자유로부터의 도피', '에리히 프롬', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=250111513', 656, 'https://image.aladin.co.kr/product/25011/15/cover500/k892632723_1.jpg');
insert into books
values(9788932039459, '나를 마릴린 먼로라고 하자', '한정현', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=289253350', 1, 'https://image.aladin.co.kr/product/28925/33/cover500/8932039453_1.jpg');

insert into books
values(9788936438715, '백의 그림자', '황정은', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=287791901', 1, 'https://image.aladin.co.kr/product/28779/19/cover500/8936438719_1.jpg');
insert into books
values(9788932474632, '인간과 사진', '제프 다이어', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=290087728', 517, 'https://image.aladin.co.kr/product/29008/77/cover500/893247463x_1.jpg');
insert into books
values(9791192085104, '동물은 어떻게 슬퍼하는가', '바버라 J. 킹', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=289172502', 656, 'https://image.aladin.co.kr/product/28917/25/cover500/k122836012_2.jpg');
insert into books
values(9788925578804, '슈퍼 해빗', '케이티 밀크먼', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=289173060', 336, 'https://image.aladin.co.kr/product/28917/30/letslook/8925578808_b.jpg');
insert into books
values(9791164051519, '생각은 어떻게 행동이 되는가', '데이비드 바드르', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=287744195', 656, 'https://image.aladin.co.kr/product/28774/41/cover500/k832836388_1.jpg');

insert into books
values(9791170400523, '이어령의 마지막 수업', '김지수', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=282121049', 656, 'https://image.aladin.co.kr/product/28212/10/cover500/k762835176_2.jpg');
insert into books
values(9791197377143, '어서 오세요, 휴남동 서점입니다', '황보름', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=286859586', 1, 'https://image.aladin.co.kr/product/28685/95/cover500/k362836265_1.jpg');
insert into books
values(9788934949671, '우리는 여전히 삶을 사랑하는가', '에리히 프롬', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=287847084', 656, 'https://image.aladin.co.kr/product/28784/70/cover500/8934949678_1.jpg');
insert into books
values(9788946422056, '꽃잎 한 장처럼', '이해인', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=289661123', 55889, 'https://image.aladin.co.kr/product/28966/11/cover500/894642205x_1.jpg');
insert into books
values(9791191891072, '나에게 고맙다', '전승환', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=289269041', 55889, 'https://image.aladin.co.kr/product/28966/11/cover500/894642205x_1.jpg');

insert into books
values(9791190278744, '직장인 A씨', '최혜인', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=274127923',38404, 'https://image.aladin.co.kr/product/27412/79/cover500/k262732555_1.jpg');
insert into books
values(9788954681179, '밝은 밤', '최은영', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=275419192', 1, 'https://image.aladin.co.kr/product/27541/91/cover500/k312835925_1.jpg');
insert into books
values(9788954677158, '긴긴밤', '루리', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=263027170', 1108, 'https://image.aladin.co.kr/product/26302/71/cover500/8954677150_1.jpg');
insert into books
values(9791165218133, '낭만적 은둔의 역사', '데이비드 빈센트', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=288524142', 656, 'https://image.aladin.co.kr/product/28852/41/cover500/k462836700_1.jpg');
insert into books
values(9791191043631, '잘 살아라 그게 최고의 복수다', '권민창', 'https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=286674266', 336, 'https://image.aladin.co.kr/product/28667/42/cover500/k372836766_1.jpg');


/******* 확인 *********
select * 
from genre, books
where genre.genre_no = books.genre_no;


///////////////////////
// playlist
///////////////////////

--#playlist_name dataType 변경--

--#데이터 타입 변경(글자수 변경)
alter table playlist 
modify playlist_name varchar2(100 char);

--#테이블 정보 삭제--
delete from playlist;

--#시퀀스 삭제--
drop sequence seq_playlist_no;

--#시퀀스 생성
create sequence seq_playlist_no
increment by 1
start with 1
nocache;

delete from user_playlist;
delete from playlist_review;
delete from playlist;

select * from emotion;
////////////////////////////////////
--#playlist_name dataType 변경--
////////////////////////////////////

--#데이터 타입 변경(글자수 변경)
alter table playlist 
modify playlist_name varchar2(100 char);

--#테이블 정보 삭제--
delete from playlist;

--#시퀀스 삭제--
drop sequence seq_playlist_no;

--#시퀀스 생성
create sequence seq_playlist_no
increment by 1
start with 1
nocache;

ALTER TABLE PLAYLIST
ADD emo_no number;

--#insert 
insert into playlist
values(seq_playlist_no.nextval, 1, sysdate, '와 이 노래가 벌써... 세월 무엇?', 1);

insert into playlist
values(seq_playlist_no.nextval, 2, sysdate, '세련된 카페 안, 나 그리고 커피와 음악', 2);

insert into playlist
values(seq_playlist_no.nextval, 3, sysdate, '이거 참 시티팝 듣기 딱 좋은 날씨네', 3);

insert into playlist
values(seq_playlist_no.nextval, 4, sysdate, '포근한 봄맞이, 달콤한 프렌치 팝', 4);

insert into playlist
values(seq_playlist_no.nextval, 2, sysdate, '힙하게 시작하는 하루!', 5);

--#전체 출력--
select * from playlist;

////////////////////////////
select playlist_name,
       playlist_no,
       emo_name
from playlist, emotion
where playlist.emo_no = emotion.emo_no;
