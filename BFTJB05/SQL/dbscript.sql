CREATE DATABASE wb7;

USE wb7;

CREATE TABLE categories (
    cat_id   int ,
    cat_name varchar(20) not null,
    cat_gst  decimal(10,2) default 0 check(cat_gst>=0),
    PRIMARY KEY (cat_id)
);

CREATE TABLE items (
    icode int primary key,
    iname varchar(50) not null,
    unit  varchar(15) not null check(unit in ('KG','LTR','PIECE','PACK')),
    price decimal(10,2) not null, 
    cat_id int not null references categories(cat_id),
    check(price>=0)
);

desc categories;
desc items;

alter table categories
add dummy varchar(15);

alter table categories
modify dummy varchar(105);

alter table categories
change dummy dummy2 varchar(105);

alter table categories
drop column dummy;

drop table items;

show tables;

insert into categories
values(101,'Farm Products',0.05);

insert into categories
values
(102,'Dairy Products',0.05),
(103,'Agri Products',0.01),
(104,'Beauty Products',0.15),
(105,'Electronics',0.15),
(106,'Packed Food',0.10);

insert into categories(cat_id,cat_name)
values(107,'Computers');

select * from categories;

update categories
set cat_gst=0.18
where cat_id=107;

delete from categories where cat_id>104;