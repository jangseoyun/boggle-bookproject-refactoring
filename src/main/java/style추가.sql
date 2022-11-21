insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 8, '#0f1960,NanumGothicEco');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 8, '#30a4ff,NanumMyeongjo');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 8, '#01ffdd,NanumPen');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 13, '##e2dea9,NanumBarunPen');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 13, '##e2dea9,NanumGothicEco');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 13, '#eeeeee,NanumMyeongjo');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 14, '#161e3c,NanumPen');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 14, '#d82249,NanumBarunPen');
insert into style(style_no, emo_no, style_name)
values(seq_style_no.nextval, 14, '#6fbf8b,NanumGothicEco');

insert into music
values(seq_music_no.nextval, 8, 'jazzy abstract beat', 'abc', 'jazzy-abstract-beat-11254');
insert into music
values(seq_music_no.nextval, 8, 'embrace', 'abc', 'embrace-12278');
insert into music
values(seq_music_no.nextval, 8, 'tenderness', 'abc', 'bensound-tenderness');
values(seq_music_no.nextval, 13, 'moment', 'abc', 'moment-14023');
insert into music
values(seq_music_no.nextval, 13, 'better days', 'abc', 'bensound-betterdays');
insert into music
values(seq_music_no.nextval, 13, 'tomorrow', 'abc', 'bensound-tomorrow');
insert into music
values(seq_music_no.nextval, 13, 'emotional piano sad background music', 'Lesfm', 'emotional-piano-sad-background-music-for-videos-5688');
insert into music
values(seq_music_no.nextval, 14, 'relax and sleep', 'Anton Vlasov', 'relax-and-sleep-18565');
insert into music
values(seq_music_no.nextval, 14, 'the cradle of your soul', 'lemonmusicstudio', 'the-cradle-of-your-soul-15700');
insert into music
values(seq_music_no.nextval, 14, 'spirit blossom', 'RomanBelov', 'spirit-blossom-15285');
insert into music
values(seq_music_no.nextval, 14, 'everything feels new', 'EvgenyBardyzha', 'everything-feels-new-15241');

UPDATE style
SET imgurl='Seoul.png'
where style_no = 6;
UPDATE style
SET imgurl='People.png'
where style_no = 7;
UPDATE style
SET imgurl='Record.png'
where style_no = 9;
UPDATE style
SET imgurl='Clouds.png'
where style_no = 10;
UPDATE style
SET imgurl='Flowers.png'
where style_no = 11;
UPDATE style
SET imgurl='Dubrovnik.png'
where style_no = 12;

UPDATE style
SET videourl='Seoul.mp4'
where style_no = 6;
UPDATE style
SET videourl='People.mp4'
where style_no = 7;
UPDATE style
SET videourl='Record.mp4'
where style_no = 9;
UPDATE style
SET videourl='Clouds.mp4'
where style_no = 10;
UPDATE style
SET videourl='Flowers.mp4'
where style_no = 11;
UPDATE style
SET videourl='Dubrovnik.mp4'
where style_no = 12;

commit;