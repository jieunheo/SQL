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
--student 데이터--
insert into student (hakbun, name) values ('001','김길동');
insert into student (hakbun, name) values ('002','성춘향');
insert into student (hakbun, name) values ('003','전우치');
insert into student (hakbun, name) values ('004','이순신');

--jumsu 데이터--
insert into jumsu(hakbun,subject,score) values ('001','과학',90);
insert into jumsu(hakbun,subject,score) values ('001','수학',80);
insert into jumsu(hakbun,subject,score) values ('001','영어',70);

insert into jumsu(hakbun,subject,score) values ('002','과학',80);
insert into jumsu(hakbun,subject,score) values ('002','수학',60);
insert into jumsu(hakbun,subject,score) values ('002','영어',100);

insert into jumsu(hakbun,subject,score) values ('003','과학',70);
insert into jumsu(hakbun,subject,score) values ('003','수학',50);
insert into jumsu(hakbun,subject,score) values ('003','영어',80);

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
where a.name='김길동';

select a.name, b.* 
from student a inner join jumsu b
on a.hakbun=b.hakbun
where a.name in('김길동','전우치');

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

select name as '성명'
from student;

--가상 테이블--
select *
from
(
	select a.name, b.* 
	from student a inner join jumsu b
	on a.hakbun=b.hakbun
	order by a.name, b.score
) vtable;