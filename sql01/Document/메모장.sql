------create------
create table memo
(
	mno int primary key auto_increment,
	mnote text
);
--auto_increment: ���� �ڵ�����
--�׻� ������ ���� �������� ������

------insert------
insert into memo (mnote)
values ('ù��° �޸��Դϴ�.');

insert into memo (mnote)
values ('�ι�° �޸��Դϴ�.');

insert into memo (mnote)
values ('����° �޸��Դϴ�.');

------delete------
delete from memo where mno=2 and mno=3;


------insert------
insert into memo (mnote)
values ('�׹�° �޸��Դϴ�.');