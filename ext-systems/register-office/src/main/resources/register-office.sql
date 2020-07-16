drop table if exists ro_employment_certificate;
drop table if exists ro_education_certificate;
drop table if exists ro_passport;
drop table if exists ro_person;

create table ro_person (
    person_id serial,
    f_name varchar(30) not null,
    l_name varchar(30) not null,
    b_day date not null,
    primary key(person_id)
);

create table ro_passport (
    passport_id serial,
    person_id integer not null,
    seria varchar(10) not null,
    number varchar(10) not null,
    issue_date date not null,
    issue_department varchar(100),
    primary key(passport_id),
    foreign key(person_id) references ro_person(person_id) on delete restrict
);

create table ro_education_certificate (
    education_certificate_id serial,
    certificate_number varchar(30) not null,
    issue_date date not null,
    person_id integer not null,
    primary key(education_certificate_id),
    foreign key(person_id) references ro_person(person_id) on delete restrict
);

create table ro_employment_certificate (
    employment_certificate_id serial,
    person_id integer not null,
    certificate_number varchar(30) not null,
    issue_date date not null,
    active_status boolean default false,
    end_date date,
    primary key(employment_certificate_id),
    foreign key(person_id) references ro_person(person_id) on delete restrict
);

insert into ro_person(f_name, l_name, b_day)
values ('Alexandr', 'Matushkin', '2000-02-12'),
('Polina', 'Kuznetsova', '2001-02-16');

insert into ro_passport(person_id, seria, number, issue_date)
values (2, '1234', '567890', '2017-03-02');

insert into ro_employment_certificate(person_id, certificate_number, issue_date)
values (2, '123456', '2015-02-07');
