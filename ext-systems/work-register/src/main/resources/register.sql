drop table if exists jr_person_job;
drop table if exists jr_job;
drop table if exists jr_person;


create table jr_person (
    person_id serial,
    f_name varchar(15) not null,
	l_name varchar(20) not null,
	b_day date not null,
	primary key(person_id)
);

insert into jr_person (f_name, l_name, b_day)
values ('Alexandr', 'Matushkin', '2000-02-12'),
('Polina', 'Kuznetsova', '2001-02-16');

create table jr_job (
    job_id serial,
    organization varchar(40) not null,
	post varchar(40) not null,
	work_start date not null,
    work_end date,
	primary key(job_id)
);

insert into jr_job (organization, post, work_start, work_end)
values ('Yat', 'administrator', '2018-09-15', '2020-02-07'),
('Meria', 'manager', '2020-07-07', null);

create table jr_person_job (
    person_job_id serial,
    person_id integer not null,
    job_id integer not null,
    partial boolean default false,
    primary key(person_job_id),
    foreign key(person_id) references jr_person(person_id) on delete restrict,
    foreign key(job_id) references jr_job(job_id) on delete restrict
);

insert into jr_person_job (job_id, person_id)
values (1 , 1),
(2 , 2);



