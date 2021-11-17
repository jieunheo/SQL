------create------
create table memo
(
	mno int primary key auto_increment,
	mnote text
);
--auto_increment: 숫자 자동증가
--항상 마지막 숫자 기준으로 증가함

------insert------
insert into memo (mnote)
values ('첫번째 메모입니다.');

insert into memo (mnote)
values ('두번째 메모입니다.');

insert into memo (mnote)
values ('세번째 메모입니다.');

------delete------
delete from memo where mno=2 and mno=3;


------insert------
insert into memo (mnote)
values ('네번째 메모입니다.');