CREATE DATABASE if not exists `commerceapp` ;

USE commerceapp;


drop table if exists User;
create table user
(
	Id int(11) primary key auto_increment,
    Email varchar(45) unique,
    Username varchar(45) not null,
    Password varchar(200) not null,/*secure*/
    Tag varchar(45),
    FirstName varchar(45),
    LastName varchar(45),
	Address varchar(45), 
    City varchar(45),
    ZipCode varchar(45) not null,
    State varchar(45) not null,
    Country varchar(45) not null,
    PicturePointer varchar(100)
)engine=InnoDB;



