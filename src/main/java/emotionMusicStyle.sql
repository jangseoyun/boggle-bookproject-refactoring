//////////////////
// emotion table
//////////////////

/********** select **********/
select * from emotion;

/********** drop sequence **********/
drop sequence seq_emotion_no;

/********** create sequence **********/
create sequence seq_emotion_no
start with 1 increment by 1;

/********** insert into emotion **********/
insert into emotion 
values(seq_emotion_no.nextval, '외로운');
insert into emotion 
values(seq_emotion_no.nextval, '심심한');
insert into emotion 
values(seq_emotion_no.nextval, '슬픈');

insert into emotion 
values(seq_emotion_no.nextval, '충만한');
insert into emotion 
values(seq_emotion_no.nextval, '편안한');

insert into emotion 
values(seq_emotion_no.nextval, '즐거운');
insert into emotion 
values(seq_emotion_no.nextval, '희망찬');
insert into emotion 
values(seq_emotion_no.nextval, '황홀한');
insert into emotion 
values(seq_emotion_no.nextval, '용감한');

insert into emotion 
values(seq_emotion_no.nextval, '불안한');
insert into emotion 
values(seq_emotion_no.nextval, '무력한');

insert into emotion 
values(seq_emotion_no.nextval, '화난');
insert into emotion 
values(seq_emotion_no.nextval, '상처입은');
insert into emotion 
values(seq_emotion_no.nextval, '회의적인');

//////////////////////
// music table
//////////////////////

/********** select music **********/
select * from music;

/********** create sequence **********/
create sequence seq_music_no
start with 1 increment by 1;

/********** insert into music **********/
insert into music
values(seq_music_no.nextval, 1, 'chilled acoustic indie folk', 'Lesm', 'chilled-acoustic-indie-folk-instrumental-background-music-for-videos-5720');
insert into music
values(seq_music_no.nextval, 1, 'slow motion', 'abc', 'bensound-slowmotion');
insert into music
values(seq_music_no.nextval, 1, 'moden chillout', 'abc', 'penguinmusic-modern-chillout-12641');
insert into music
values(seq_music_no.nextval, 1, 'this minimal technology', 'abc', 'this-minimal-technology-12327');
insert into music
values(seq_music_no.nextval, 1, 'town', 'abc', 'town-10169');
insert into music
values(seq_music_no.nextval, 2, 'relax and sleep', 'Anton Vlasov', 'relax-and-sleep-18565');
insert into music
values(seq_music_no.nextval, 2, 'the cradle of your soul', 'lemonmusicstudio', 'the-cradle-of-your-soul-15700');
insert into music
values(seq_music_no.nextval, 2, 'spirit blossom', 'RomanBelov', 'spirit-blossom-15285');
insert into music
values(seq_music_no.nextval, 2, 'everything feels new', 'EvgenyBardyzha', 'everything-feels-new-15241');
insert into music
values(seq_music_no.nextval, 3, 'moment', 'abc', 'moment-14023');
insert into music
values(seq_music_no.nextval, 3, 'better days', 'abc', 'bensound-betterdays');
insert into music
values(seq_music_no.nextval, 3, 'tomorrow', 'abc', 'bensound-tomorrow');
insert into music
values(seq_music_no.nextval, 3, 'emotional piano sad background music', 'Lesfm', 'emotional-piano-sad-background-music-for-videos-5688');
insert into music
values(seq_music_no.nextval, 4, 'jazzy abstract beat', 'abc', 'jazzy-abstract-beat-11254');
insert into music
values(seq_music_no.nextval, 4, 'embrace', 'abc', 'embrace-12278');
insert into music
values(seq_music_no.nextval, 4, 'tenderness', 'abc', 'bensound-tenderness');
insert into music
values(seq_music_no.nextval, 5, 'both of us', 'abc', 'both-of-us-14037');
insert into music
values(seq_music_no.nextval, 5, 'morning garden', 'abc', 'morning-garden-acoustic-chill-15013');
insert into music
values(seq_music_no.nextval, 6, 'sunny', 'abc', 'moment-14023');
insert into music
values(seq_music_no.nextval, 6, 'energy', 'abc', 'bensound-energy');
insert into music
values(seq_music_no.nextval, 6, 'whale', 'nct dream', 'whale');
insert into music
values(seq_music_no.nextval, 7, 'let it go', 'abc', 'let-it-go-12279');
insert into music
values(seq_music_no.nextval, 7, 'going higher', 'abc', 'bensound-goinghigher');
insert into music
values(seq_music_no.nextval, 9, 'indie folk king around here', 'abc', 'indie-folk-king-around-here-15045');
insert into music
values(seq_music_no.nextval, 9, 'melodic techno', 'abc', 'melodic-techno-03-extended-version-moogify-9867');
insert into music
values(seq_music_no.nextval, 10, 'into the night', 'abc', 'into-the-night-20928');
insert into music
values(seq_music_no.nextval, 10, 'caves of dawn', 'abc', 'caves-of-dawn-10376');
insert into music
values(seq_music_no.nextval, 11, 'rest of the fallen', 'GuilhermeBernardes', 'rest-of-the-fallen-10378');
insert into music
values(seq_music_no.nextval, 11, 'fluidity', 'abc', 'fluidity-100-ig-edit-4558');
insert into music
values(seq_music_no.nextval, 12, 'don’t you think  lose', 'abc', 'dont-you-think-lose-16073');
insert into music
values(seq_music_no.nextval, 12, 'ever flowing', 'abc', 'ever-flowing-12277');

///////////////////////////
// style table
///////////////////////////

/********** delete style data **********/
delete from style;

/********** select style **********/
select * from style;

/**********drup sequence  **********/
drop sequence seq_style_no;

/********** create sequence **********/
create sequence seq_style_no
start with 1 increment by 1;

/********** insert into style **********/
insert into style
values(seq_style_no.nextval, 1, '#f905fb,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 1, '#ff7dfe,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 1, '#ffcaff,NanumPen');
insert into style
values(seq_style_no.nextval, 2, '#8c8cff,NanumBarunPen');
insert into style
values(seq_style_no.nextval, 2, '#5151ff,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 2, '#0000c8,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 3, '#a5dbff,NanumPen');
insert into style
values(seq_style_no.nextval, 3, '#59bdff,NanumBarunPen');
insert into style
values(seq_style_no.nextval, 3, '#0089e0,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 4, '#ffffb1,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 4, '#ffff54,NanumPen');
insert into style
values(seq_style_no.nextval, 4, '#ffe854,NanumBarunPen');

insert into style
values(seq_style_no.nextval, 5, '#ff7d00,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 5, '#ffa854,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 5, '#ffc48c,NanumPen');
insert into style
values(seq_style_no.nextval, 6, '#9adcffv,NanumBarunPen');
insert into style
values(seq_style_no.nextval, 6, '#fff89a,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 6, '#ffb2a6,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 7, '#029268,NanumPen');
insert into style
values(seq_style_no.nextval, 7, '#01c897,NanumBarunPen');
insert into style
values(seq_style_no.nextval, 7, '#ffd366,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 9, '#640707,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 9, '#89100e,NanumPen');
insert into style
values(seq_style_no.nextval, 9, '#e83b15,NanumBarunPen');

insert into style
values(seq_style_no.nextval, 10, '#0f1960,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 10, '#30a4ff,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 10, '#01ffdd,NanumPen');
insert into style
values(seq_style_no.nextval, 11, '##e2dea9,NanumBarunPen');
insert into style
values(seq_style_no.nextval, 11, '##e2dea9,NanumGothicEco');
insert into style
values(seq_style_no.nextval, 11, '#eeeeee,NanumMyeongjo');
insert into style
values(seq_style_no.nextval, 12, '#161e3c,NanumPen');
insert into style
values(seq_style_no.nextval, 12, '#d82249,NanumBarunPen');
insert into style
values(seq_style_no.nextval, 12, '#6fbf8b,NanumGothicEco');




ALTER TABLE style
ADD imgurl varchar2(1000);

ALTER TABLE style
ADD videourl varchar2(1000);

UPDATE style
SET imgurl='rainywindow.png'
where style_no = 1;
UPDATE style
SET imgurl='rainyday.png'
where style_no = 2;
UPDATE style
SET imgurl='puppy1.png'
where style_no = 3;
UPDATE style
SET imgurl='puppy2.png'
where style_no = 4;
UPDATE style
SET imgurl='moon.png'
where style_no = 5;

UPDATE style
SET videourl='rainywindow.mp4'
where style_no = 1;
UPDATE style
SET videourl='rainyday.mp4'
where style_no = 2;
UPDATE style
SET videourl='puppy1.mp4'
where style_no = 3;
UPDATE style
SET videourl='puppy2.mp4'
where style_no = 4;
UPDATE style
SET videourl='moon.mp4'
where style_no = 5;
