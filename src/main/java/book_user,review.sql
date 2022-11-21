--#해당 책을 좋아요한 사용자(북마크)
--##############[book_user 테이블]#############-----

--#시퀀스 삭제--
drop sequence seq_book_user_no;

--#시퀀스 생성
create sequence seq_book_user_no
increment by 1
start with 1
nocache;

--#insert 
insert into book_user
values(seq_book_user_no.nextval, 9791189327156, 1, sysdate );
insert into book_user
values(seq_book_user_no.nextval, 9791189327156, 2, sysdate );
insert into book_user
values(seq_book_user_no.nextval, 9791189327156, 3, sysdate );
insert into book_user
values(seq_book_user_no.nextval, 9791189327156, 4, sysdate );


insert into book_user
values(seq_book_user_no.nextval, 9791197037153, 1, sysdate );
insert into book_user
values(seq_book_user_no.nextval, 9791197037153, 5, sysdate );
insert into book_user
values(seq_book_user_no.nextval, 9791197037153, 6, sysdate );


insert into book_user
values(seq_book_user_no.nextval, 9791166686603, 4, sysdate );

insert into book_user
values(seq_book_user_no.nextval, 9791160804751, 5, sysdate );

insert into book_user
values(seq_book_user_no.nextval, 9788932039459, 6, sysdate );
insert into book_user
values(seq_book_user_no.nextval, 9788932039459, 3, sysdate );
insert into book_user
values(seq_book_user_no.nextval, 9788932039459, 2, sysdate );

insert into book_user
values(seq_book_user_no.nextval, 9791192085104, 3, sysdate );


--#전체 출력--
select *
from book_user;


--#해당 데이터 삭제(북마크 취소)--
delete from book_user
where user_no = 1;

//////////////////
// review table
//////////////////

/********** select **********/
select * from review;

/********** drop sequence **********/
drop sequence seq_review_no;

/********** create sequence **********/
create sequence seq_review_no
INCREMENT BY 1 
START WITH 1 ;


/********** insert into review **********/
insert into review
values(seq_review_no.nextval, 1 , 9791189327156,
        1,'우리가 어류에 대해 해온 일이 바로 이와 똑같다. 수많은 미묘한 차이들을 “어류”라는 하나의 단어 아래 몰아넣은 것이다.', sysdate);
insert into review
values(seq_review_no.nextval, 2 , 9791197037153,
        2,'취향이 없을 때의 나는 무기력하고 나약했다. 상대의 결정만을따르면서 모든 선택에서 물러나길 밥 먹듯 했다. 그러다 문득, 나를잃고 있다는 생각이 머릿속을 스쳤다. 오로지 타인만을 위했던 행동이 나를 버리는 일이었다는 걸 깨닫게 된 것이다.', sysdate);
insert into review
values(seq_review_no.nextval, 3 , 9791166686603,
        3,'세상은 원래부터 기괴하고 무섭고 아름답고 당황스러웠다. 그동안 우리는 두꺼운 습관의 담요를 뒤집어 쓰고 이를 무시하고 있었을 뿐이다. 그리고 김보영의 단편들을 읽는 것은 그 담요를 은근슬적 떨구는 과정이다. ', sysdate);
insert into review
values(seq_review_no.nextval, 4 , 9791160804751,
        4,'내가 보기에 해결책은 하나뿐이다. 우리의 사회생활에서 가장 본질적인 사실들에 대한 인식을 강화하는 것이다. 그 인식은 우리가돌이킬 수 없는 어리석은 짓을 저지르는 것을 막아주고, 객관성과이성을 유지할 수 있는 능력을 조금이나마 높여준다.', sysdate);
insert into review
values(seq_review_no.nextval, 5 , 9788932039459,
        5,'반짝이는 이 소설의 끝에 계속 머물고 싶었다. 기억이 금지당한 우리를 영원히 살게 할 것을 기억하면서. ', sysdate);
insert into review
values(seq_review_no.nextval, 6 , 9788936438715,
        6,'처음엔 그림자라는 것을 알지 못했다. 덤불을 벌리고 들어가는 모습을 보고 저쪽도 길인가 싶고 뒷모습이 낯익기도 해서 따라 들어갔다. 들어갈수록 숲은 깊어지는데 뒷모습에 이끌려서 자꾸자꾸 들어갔다.불을 벌리고 들어가는 모습을 보고 저쪽도 길인가 싶고 뒷모습이 낯익기도 해서 따라 들어갔다.', sysdate);


insert into review
values(seq_review_no.nextval, 1 , 9788932474632,
        7,'예술에 관한 깊은 사유를 멋진 문장 속에 담는 일은 무척 매혹적이다. 그러나 그만큼 어려운 일이기도 하다. 사진 비평으로 분야를 한정한다면, 이런 작업을 가장 잘 수행할 수 있는 사람은 제프 다이어일 것이다. ', sysdate);
insert into review
values(seq_review_no.nextval, 2 , 9791192085104,
        8,'동물이 겪는 사별을 주제로 글을 쓰고 있지만, 나는 지금 두 장대 사이에 팽팽하게 묶인 줄 위를 걷는 기분이다. 하나의 장대는 동물들의 감정적 삶이 인정받기를 바라는 마음이고, 다른 하나의 장대는 인간의 독특한 특성을 예우하고 싶은 내 욕구다.', sysdate);
insert into review
values(seq_review_no.nextval, 3 , 9788925578804,
        9,'자기계발 분야의 수많은 베스트셀러가 한목소리로 말한다. 목표 달성은 ‘습관’에 달렸다고. 그런데 왜 사람들은 여전히 목표를 이루지 못하고 있는가? 왜 야심 차게 세운 계획은 항상 작심삼일로 끝나는가?', sysdate);
insert into review
values(seq_review_no.nextval, 4 , 9791164051519,
        10,'“우리는 자신이나 남들이 어떤 일을 해내지 못하는 걸 보고 그것을 해석할 때 보통 이 간극을 간과한다. 수업을 받았더라도 꾸준히 실천하도록 자신의 삶을 조직하지 못했을지 모른다. 요컨대, 안다는 것은 그 싸움의 절반일 수 있지만, 나머지 절반도 우습게 여겨서는 안 된다.”', sysdate);

insert into review
values(seq_review_no.nextval, 5 ,'9791170400523',
        11,'영화가 끝나고 the end 마크가 찍힐 때마다 나는 생각했네. 나라면 저기에 꽃봉오리를 놓을 텐데. 그러면 끝이 난 줄 알았던 그 자리에 누군가 와서 언제든 다시 이야기가 시작될 수 있을 텐데. 그때의 라스트 인터뷰가 끝이 아니고, 다시 지금의 라스트 인터뷰로 이어지듯이. 인생이 그래.', sysdate);
insert into review
values(seq_review_no.nextval, 6 ,'9791197377143',
        12,'하루 중 이 시간만 확보하면 그런대로 살 수 있을 것 같은 기분이야. 우리 인간은 복잡하게 만들어졌지만 어느 면에선 꽤 단순해. 이런 시간만 있으면 돼. 숨통 트이는 시간. 하루에 10분이라도, 한 시간이라도. 아, 살아 있어서 이런 기분을 맛보는구나 하고 느끼게 되는 시간.', sysdate);
insert into review
values(seq_review_no.nextval, 1 ,'9788934949671',
        13,'실제 삶에 대한 무관심 중 대부분은 삶에 대한 은폐된 적개심이며 삶과 살아 있는 것에 대한 사랑이 무력해졌다는 확실한 증거다.', sysdate);
insert into review
values(seq_review_no.nextval, 2 ,'9788946422056',
        14,'자신의 아픔과 슬픔은 하찮은 것에도 그리 민감하면서 다른 사람의 엄청난 아픔과 슬픔엔 안일한 방관자였음을 용서하소서.', sysdate);
insert into review
values(seq_review_no.nextval, 3 ,'9791191891072',
        15,'누군가 당신을 싫어한다고 해서, 미워한다고 해서 변하는 건 없어요. 그건 그 사람의 생각일 뿐, 당신의 삶에 영향을 주지는 않으니까요. 거절이 필요한 순간을 외면하지 않는다면 우리는 벅찬 인간관계에서 자유로워질 수 있어요.', sysdate);

insert into review
values(seq_review_no.nextval, 4 ,'9791190278744',
        16,'구직이 어려워 퇴사를 망설이는 당신에게 내 탓이라고 생각하지 않는다, 더 큰 상처를 견뎌야 할 이유는 없다. 내가 이상하다는 착각에 빠지지 말라.', sysdate);
insert into review
values(seq_review_no.nextval, 5 ,'9788954681179',
        17,'그녀에게는 그런 재능이 있었다. 어떤 경우에도 자신을 속이지 않는 재능. 부당한 일은 부당한 일로, 슬픈 일은 슬픈 일로, 외로운 마음은 외로운 마음으로 느끼는 재능.', sysdate);
insert into review
values(seq_review_no.nextval, 6 ,'9788954677158',
        18,'나로 살아간다는 것의 고통과 두려움과 환희를 단순하지만 깊이있게 보여준다. 지금의 내가 있기까지 나를 향해있던 모든 이의 긴긴밤을 그 눈물과 고통과 연대와 사랑을 이야기한다.', sysdate);
insert into review
values(seq_review_no.nextval, 1 ,'9791165218133',
        19,'온갖 논의가 있어도, 은둔과 사회성에 큰 변화가 생겨도, 고독의 경험에는 뚜렷한 핵심이 남아 있다. 1791년 요한 치머만이 고독을 두고 “자기 회복을 위한 성향”이라고 한 정의는 우리 시대에도 유효하다.', sysdate);
insert into review
values(seq_review_no.nextval, 2 ,'9791191043631',
        20,'나를 무시하고 경멸했던 사람들에게 어떻게든 복수하려고 내 소중한 시간을 낭비하지 마라. 완전히 잊고 살며 그냥 내가 하는 최선을 다하고 살면 된다.', sysdate);

