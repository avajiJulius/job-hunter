drop table if exists wr_person_work;
drop table if exists wr_person;
drop table if exists wr_last_work;


create table wr_last_work (
    last_work_id serial,
    organization varchar(40) not null,
	position varchar(40) not null,
	primary key(last_work_id)
);

insert into wr_last_work (organization, position)
values ('Petrusha', 'waiter'), ('Yat', 'administrator');

create table wr_person (
    person_id serial,
    f_name varchar(15) not null,
	l_name varchar(20) not null,
	b_day date not null,
	primary key(person_id)
);

insert into wr_person (f_name, l_name, b_day)
values ('Alexandr', 'Matushkin', '2000-02-12');

create table wr_person_work (
    person_work_id serial,
    last_work_id integer not null,
    person_id integer not null,
    work_start date not null,
    work_end date,
    partial boolean default false,
    primary key(person_work_id),
    foreign key(last_work_id) references wr_last_work(last_work_id) on delete restrict,
    foreign key(person_id) references wr_person(person_id) on delete restrict
);

insert into wr_person_work (last_work_id, person_id, work_start, work_end)
values (2 , 1, '2018-09-15', '2020-02-07');