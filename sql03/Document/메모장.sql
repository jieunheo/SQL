------drop------
drop table memo;
------create------
create table memo
(
	mno int primary key auto_increment,
	mtitle VARCHAR(200),
	mnote text,
	mdate DATETIME default now()
);
--default: 기본값 지정--
--now(): 현재 시간 함수--

------insert------
insert into memo (mtitle, mnote)
values ('첫번째 제목입니다.','첫번째 메모입니다.');

insert into memo (mtitle, mnote)
values ('두번째 제목입니다.','두번째 메모입니다.');

insert into memo (mtitle, mnote)
values ('세번째 제목입니다.','세번째 메모입니다.');

--아래와 같이 한번에 넣는 것도 가능
--insert into memo (mtitle, mnote)
--values ('첫번째 제목입니다.','첫번째 메모입니다.'),
--values ('두번째 제목입니다.','두번째 메모입니다.'),
--values ('세번째 제목입니다.','세번째 메모입니다.');

------update------
update memo set mtitle = 'My Title';

------select------
select mno, mnote from memo order by mno desc;
