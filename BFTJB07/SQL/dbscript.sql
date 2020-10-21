
create database wb5;

show databases;

use wb5;

create table dummy(
    dummyCol int
);

show tables;

desc dummy;

alter table dummy
add  dummyCol2 char(10);

alter table dummy
modify dummyCol2 varchar(100);

alter table dummy
change dummyCol2 dc2 varchar(150);

alter table dummy
drop column dc2;

drop table dummy;

create table Courses(
    crId    int primary key,
    crName  varchar(20) not null,
    crFee   decimal(10,2) not null check(crFee>=1500)
);

create table Students(
    stNum   int primary key,
    sName   varchar(50) not null,
    mobile  char(10)    unique,
    crId    int         references Courses(crId)
);

INSERT INTO Courses
Values(101,'DevOps',25000);

INSERT INTO Courses
Values
        (102,'Java SE',25000),
        (104,'Servlets and JSP',15000),
        (105,'Spring Core',35000),
        (106,'Spring Web MVC',55000);

INSERT INTO Students(stNum,sName)
VALUES (201,'Subha');        

INSERT INTO Students
Values
        (202,'Vamsy',null,101),
        (203,'Sagar','9948016004',101),
        (204,'Srinu','9052224753',102),
        (205,'Venky','9090909098',102),
        (206,'Indhikaa',null,103);

SELECT * FROM Courses;
SELECT * FROM Students;        

UPDATE Students
SET mobile='3445566777'
WHERE stNum=206;

UPDATE Students
SET mobile='9445566777',crId=901
WHERE stNum=201;

DELETE FROM Students WHERE stNum>=205;