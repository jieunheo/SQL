------create table------
create table student(
	hakbun varchar(10) not null primary key,
	name varchar(20)
);

create table jumsu(
	hakbun varchar(10),
	subject varchar(20),
	score int,
	foreign key(hakbun) references student(hakbun)
);

------insert------
--student ������--
insert into student (hakbun, name) values ('001','��浿');
insert into student (hakbun, name) values ('002','������');
insert into student (hakbun, name) values ('003','����ġ');
insert into student (hakbun, name) values ('004','�̼���');

--jumsu ������--
insert into jumsu(hakbun,subject,score) values ('001','����',90);
insert into jumsu(hakbun,subject,score) values ('001','����',80);
insert into jumsu(hakbun,subject,score) values ('001','����',70);

insert into jumsu(hakbun,subject,score) values ('002','����',80);
insert into jumsu(hakbun,subject,score) values ('002','����',60);
insert into jumsu(hakbun,subject,score) values ('002','����',100);

insert into jumsu(hakbun,subject,score) values ('003','����',70);
insert into jumsu(hakbun,subject,score) values ('003','����',50);
insert into jumsu(hakbun,subject,score) values ('003','����',80);

------select------
----select join----
select * 
from student inner join jumsu
on student.hakbun=jumsu.hakbun;

select student.name, jumsu.* 
from student inner join jumsu
on student.hakbun=jumsu.hakbun;

select a.name, b.* 
from student a inner join jumsu b
on a.hakbun=b.hakbun;

select a.name, b.* 
from student a inner join jumsu b
on a.hakbun=b.hakbun
order by b.score desc;

select a.name, b.* 
from student a inner join jumsu b
on a.hakbun=b.hakbun
order by a.name, b.score desc;

select a.name, b.* 
from student a inner join jumsu b
on a.hakbun=b.hakbun
where a.name='��浿';

select a.name, b.* 
from student a inner join jumsu b
on a.hakbun=b.hakbun
where a.name in('��浿','����ġ');

select a.name, sum(b.score), avg(b.score)
from student a inner join jumsu b
on a.hakbun=b.hakbun
group by a.name
order by b.score;

select a.name, sum(b.score) as mysum, avg(b.score) as myavg
from student a inner join jumsu b
on a.hakbun=b.hakbun
group by a.name
order by b.score;

select name as '����'
from student;

--���� ���̺�--
select *
from
(
	select a.name, b.* 
	from student a inner join jumsu b
	on a.hakbun=b.hakbun
	order by a.name, b.score
) vtable;