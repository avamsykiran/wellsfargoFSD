-- This file contains the db script for
-- Inventory Management System Database

DROP DATABASE imsDb;

CREATE DATABASE imsDb;

USE imsDb;

CREATE TABLE items(
	icode int primary key,
	title varchar(20) not null,
	packageDate date not null,
	fragile boolean default false,
	unit varchar(10) not null,
	costPrice decimal not null,
	sellingPrice decimal not null
);

INSERT INTO items VALUES
(1,"Pen Stand","2020-02-01",false,"piece",100,200),
(2,"Marker ","2020-02-01",false,"Box of 10",120,220),
(3,"Catridge B/W","2020-02-01",true,"piece",500,600);