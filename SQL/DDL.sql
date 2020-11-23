CREATE DATABASE if not exists `commerceapp` ;

USE commerceapp;


drop table if exists User;
create table user
(
	Id int(11) primary key auto_increment,
    Email varchar(45) unique,
    Username varchar(75) not null,
    Password varchar(200) not null,/*secure*/
    Tag varchar(45),
    Firstname varchar(45),
    Lastname varchar(45),
	Address varchar(45), 
    City varchar(45),
    Zipcode varchar(45) not null,
    State varchar(45) not null,
    Country varchar(45) not null,
    Picturepointer varchar(100)
)engine=InnoDB;

drop table if exists Tokens;
create table Tokens
(
Id int(11) primary key auto_increment,
val varchar(200) unique not null,
email varchar(45) unique,
foreign key(email) references User(email),
expires int(255) not null
 
 
)engine=InnoDB;


