create database springboot;

create table `user`(
id varchar(32) not null unique,
name varchar(50) not null,
pass varchar(50) not null,
email varchar(20),
iphone varchar(20),
primary key(id)
)