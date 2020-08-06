
DROP DATABASE cmsDb;

CREATE DATABASE cmsDb;

USE cmsDb;

CREATE TABLE Contacts(
	cid int primary key,
	cname varchar(20) not null,
	dob date not null,
	mobile char(10) unique 
);

INSERT INTO Contacts VALUES
(1,"Vamsy","1985-06-11","9948016004"),
(2,"Latha","1986-05-11","9948016504"),
(3,"Prem","1987-03-11","9948316004"); 