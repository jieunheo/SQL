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
--default: �⺻�� ����--
--now(): ���� �ð� �Լ�--

------insert------
insert into memo (mtitle, mnote)
values ('ù��° �����Դϴ�.','ù��° �޸��Դϴ�.');

insert into memo (mtitle, mnote)
values ('�ι�° �����Դϴ�.','�ι�° �޸��Դϴ�.');

insert into memo (mtitle, mnote)
values ('����° �����Դϴ�.','����° �޸��Դϴ�.');

--�Ʒ��� ���� �ѹ��� �ִ� �͵� ����
--insert into memo (mtitle, mnote)
--values ('ù��° �����Դϴ�.','ù��° �޸��Դϴ�.'),
--values ('�ι�° �����Դϴ�.','�ι�° �޸��Դϴ�.'),
--values ('����° �����Դϴ�.','����° �޸��Դϴ�.');

------update------
update memo set mtitle = 'My Title';

------select------
select mno, mnote from memo order by mno desc;
