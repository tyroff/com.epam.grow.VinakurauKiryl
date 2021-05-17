-- Task 1
-- Video library. The database stores information about the home video library - films, actors, directors.
-- For movies, you must store:

-- name;
-- names of actors;
-- release date;
-- the country in which the film is released.

-- For actors and directors, you must store:

-- FULL NAME;
-- date of birth.

-- Find all the films that appeared on the screen in the current and last year.
-- Display information about the actors who starred in a given film.
-- Display information about actors who starred in at least N films.
-- Display information about actors who were directors at least one of the films.
-- Delete all films whose release date was more than the specified years ago.

create database "videoLibrary";

create table "Role" (
	"id" int primary key,
	"name" varchar(30) not null unique
);
insert into "Role"("id", "name") values
(1, 'actor'),
(2, 'director');

create table "Person" (
	"id" int primary key,
	"first_name" varchar(20) not null,
	"last_name" varchar(30) not null,
	"birth_date" date not null
);
insert into "Person"("id", "first_name", "last_name", "birth_date") values
(1, 'Vin', 'Dizel', '1967-07-18'),
(2, 'Dzhon', 'Sina', '1977-04-23'),
(3, 'Tayriz', 'Gibson', '1978-12-30'),
(4, 'Dzhordana', 'Bryuster', '1980-04-26');

create table "Person_Role" (
    "id" int primary key,
    "id_Person" int not null,
    "id_Role" int not null,
    foreign key("id_Person") references "Person"("id"),
    foreign key("id_Role") references "Role"("id")
);
insert into "Person_Role"("id", "id_Person", "id_Role") values
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 2),
(5, 3, 1),
(6, 4, 1);

create table "Country" (
	"id" int primary key,
	"name" varchar(50) not null unique
);
insert into "Country"("id", "name") values
(1, 'USA'),
(2, 'Russia'),
(3, 'Belarus');


create table "Film" (
    "id" int primary key,
    "name" varchar(150) not null unique,
    "release_year" int not null
);
insert into "Film"("id", "name", "release_year") values
(1, 'The Fast and the Furious', 2001),
(2, 'The Fast and the Furious 9', 2021);


create table "Film_Country" (
    "id" int primary key,
	"id_Film" int not null, foreign key ("id_Film") references "Film"("id") on delete cascade,
	"id_Country" int not null, foreign key ("id_Country") references "Country"("id")
);
insert into "Film_Country"("id", "id_Film", "id_Country") values
(1, 1, 1),
(2, 2, 1);

create table "Film_Country_Person_Role" (
	"id_Film_Country" int not null, foreign key ("id_Film_Country") references "Film_Country"(id) on delete cascade,
	"id_Person_Role" int not null, foreign key ("id_Person_Role") references "Person_Role"(id)
);
insert into "Film_Country_Person_Role"("id_Film_Country", "id_Person_Role") values
(1, 1),
(1, 2),
(1, 3),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6);

-- Find all the films that appeared on the screen in the current and last year.
select "name" from "Film" where "release_year" >= 2020

-- Display information about the actors who starred in a given film.
select *
from "Person"
where "id" in (
	select "id_Person_Role"
	from "Film_Country_Person_Role"
	where "id_Film_Country" = (
		select "id"
		from "Film"
		where "release_year" >= 2020))

-- Display information about actors who starred in at least N films.
select *
from "Person"
where "id" in (
	select distinct "id_Person"
	from "Person_Role"
	where "id_Role" = 1 and "id" in (
		select "id_Person_Role"
		from "Film_Country_Person_Role"
		group by "id_Person_Role"
		having count("id_Person_Role") > 1));

-- Display information about actors who were directors at least one of the films.
select *
from "Person"
where "id" in (
	select distinct "id_Person"
	from "Person_Role"
	where "id_Role" = 2 and "id" in (
		select "id_Person_Role"
		from "Film_Country_Person_Role"
		group by "id_Person_Role"
		having count("id_Person_Role") > 0));

-- Delete all films whose release date was more than the specified years ago.
delete from "Film"
where "release_year" < 2021
