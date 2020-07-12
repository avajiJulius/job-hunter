drop table if exists jr_person;

create table jr_person (
    person_id serial,
    f_name varchar(30) not null,
    l_name varchar(30) not null,
    primary key(person_id)
)