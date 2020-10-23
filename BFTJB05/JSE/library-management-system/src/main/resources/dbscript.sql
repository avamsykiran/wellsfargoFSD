DROP DATABASE IF EXISTS lmsdb;

CREATE DATABASE lmsdb;

USE lmsdb;

CREATE TABLE books (
	b_code INT PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	publish_data DATE NOT NULL,
	category VARCHAR(50) NOT NULL
);

INSERT INTO books VALUES
	(101,'Let Us C',254.0,'1999-09-09','TEXT_BOOK'),
	(102,'Let Us C++',854.0,'1999-12-09','TEXT_BOOK'),
	(103,'Sherlock Homles',1254.0,'1999-01-09','NOVEL'),
	(104,'Macbeth',2254.0,'1998-09-09','NOVEL'),
	(105,'Java Head First',2354.0,'2000-09-09','TEXT_BOOK'); 
	