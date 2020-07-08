DROP TABLE IF EXISTS jh_jobs;
DROP TABLE IF EXISTS jh_employee_forms;
DROP TABLE IF EXISTS jh_courses;
DROP TABLE IF EXISTS jh_universities;
DROP TABLE IF EXISTS jh_cities;

CREATE TABLE jh_cities (
    city_id integer not null,
    city_name varchar(30) not null,
    PRIMARY KEY(city_id)
);

insert into jh_cities (city_id, city_name) values
(1, 'Saint-Petersburg'),
(2, 'Moscow'),
(3, 'Kaliningrad'),
(4, 'Ekatirinburg'),
(5, 'Samara');

CREATE TABLE jh_universities (
    university_id integer not null,
    university_name varchar(40) not null,
    PRIMARY KEY(university_id)
);

insert into  jh_universities (university_id, university_name) values
(1, 'Herzen University'),
(2, 'Pliteh University'),
(3 , 'MGU');

CREATE TABLE jh_courses (
    course_id integer not null,
    course_name varchar(40) not null,
    PRIMARY KEY(course_id)
);

insert into jh_courses(course_id, course_name) values
(1, 'CS50'),
(2, 'Coursera JavaCourse'),
(3 , 'other');

CREATE TABLE jh_employee_forms (
	e_form_id SERIAL,
	e_form_post varchar(50) not null,
	e_form_status int not null,
	e_form_date timestamp not null,
	f_name varchar(15) not null,
	l_name varchar(20) not null,
	b_day date not null,
	city_id integer not null,
	email varchar(30) not null,
    profession int not null,
    schedule_status int not null,
    experience double precision,
    salary double precision,
    university_id integer not null,
    course_id integer not null,
	about text,
    PRIMARY KEY(e_form_id),
    FOREIGN KEY(university_id) REFERENCES jh_universities(university_id) ON DELETE RESTRICT,
    FOREIGN KEY(course_id) REFERENCES jh_courses(course_id) ON DELETE RESTRICT,
	FOREIGN KEY(city_id) REFERENCES jh_cities(city_id) ON DELETE RESTRICT
);

CREATE TABLE jh_jobs (
	job_id SERIAL,
	e_form_id integer not null,
	organization varchar(40) not null,
	work_start date not null,
	work_end date not null,
	post varchar(40) not null,
	PRIMARY KEY(job_id),
	FOREIGN KEY(e_form_id) REFERENCES jh_employee_forms(e_form_id) ON DELETE RESTRICT
);
