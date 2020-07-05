drop table if exists wr_person_work;
drop table if exists wr_last_work;
drop table if exists wr_person;


create table wr_person (
    person_id serial,
    f_name varchar(15) not null,
	l_name varchar(20) not null,
	b_day date not null,
	primary key(person_id)
);

insert into wr_person (f_name, l_name, b_day)
values ('Alexandr', 'Matushkin', '2000-02-12'),
('Polina', 'Kuznetsova', '2001-02-16');

create table wr_last_work (
    last_work_id serial,
    organization varchar(40) not null,
	position varchar(40) not null,
	work_start date not null,
    work_end date,
	primary key(last_work_id)
);

insert into wr_last_work (organization, position, work_start, work_end)
values ('Yat', 'administrator', '2018-09-15', '2020-02-07'),
('Meria', 'manager', '2020-07-07', null);

create table wr_person_work (
    person_work_id serial,
    person_id integer not null,
    last_work_id integer not null,
    partial boolean default false,
    primary key(person_work_id),
    foreign key(person_id) references wr_person(person_id) on delete restrict,
    foreign key(last_work_id) references wr_last_work(last_work_id) on delete restrict
);

insert into wr_person_work (last_work_id, person_id)
values (1 , 1),
(2 , 2);



