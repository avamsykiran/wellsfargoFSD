create table items2 
(
icode integer primary key, 
costprice double not null, 
fragile bit, 
packagedate date not null, 
sellingprice double not null, 
title varchar(20) not null, 
unit varchar(10) not null
);