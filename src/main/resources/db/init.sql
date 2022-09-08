create database cabinrent

create table cabins
(
    id integer not null,
    name varchar(50),
    owner_id integer not null,
    price integer,
    location varchar(100)
)

CREATE TABLE images
(
    id integer NOT NULL,
    name character varying(50),
    cabin_id integer NOT NULL
)

create table users
(
    id integer not null,
    name varchar(50),
    email varchar(50),
    phone integer
)

create table facilities
(
    id integer not null,
    name varchar(50)
)

create table cabin_facility
(
id integer not null,
cabin_id integer,
facility_id integer,
quantity integer
)

create table owners(
	id integer primary key not null,
	name varchar(100),
	email varchar(100),
	phone varchar(100),
	cabin_id integer
)

