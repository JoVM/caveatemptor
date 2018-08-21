--liquibase formatted sql
--changeset amudhan:1
drop table if exists category;
drop table if exists user_details;
drop table if exists item;
drop table if exists image;
drop table if exists address;
drop table if exists bid;
drop table if exists bankaccount;
drop table if exists creditcard;
drop table if exists billingdetails;

create table category(id int unsigned primary key auto_increment, name varchar(50), parentid int unsigned default null, 
	constraint fk_parentid foreign key(parentid) references category(id) on delete set null);
create table user_details(id int unsigned primary key auto_increment, firstname varchar(50) not null, lastname varchar(50), usertype varchar(10) not null);
create table item(id int unsigned primary key auto_increment, name varchar(100) not null, initialprice decimal not null, auctionstart timestamp default CURRENT_TIMESTAMP, 
	auctionend timestamp default CURRENT_TIMESTAMP, is_auction_ended bit(1) default 0, is_auction_in_progress bit(1) default 0, description text, sellerid int unsigned not null, categoryid int unsigned default null,
	constraint fk_sellerid_item foreign key(sellerid) references user_details(id) on delete cascade, 
	constraint fk_categoryid_item foreign key(categoryid) references category(id) on delete set null);
create table image(id int unsigned primary key auto_increment, name varchar(50), imageurl varchar(255) not null, itemid int unsigned not null, 
	constraint fk_itemid_image foreign key(itemid) references item(id) on delete cascade);
create table address(id int unsigned primary key auto_increment, addresstype varchar(20) not null, building varchar(50) not null, street varchar(50) not null,   
	city varchar(50) not null, zipcode varchar(20) not null, userid int unsigned not null, constraint fk_userid_address foreign key(userid) references user_details(id) on delete cascade);
create table bid(id int unsigned primary key auto_increment, amount decimal not null, createdon timestamp not null, issuccess bit(1) default 0, itemid int unsigned not null, bidderid int unsigned not null, 
	constraint fk_itemid_bidding foreign key(itemid) references item(id) on delete cascade,
	constraint fk_bidderid_bidding foreign key(bidderid) references user_details(id) on delete cascade);
create table creditcard(id int unsigned primary key auto_increment, creditcardnumber varchar(30) not null, expirymonth int not null, expiryyear int not null, 
	userid int unsigned not null, constraint fk_userid_cc foreign key(userid) references user_details(id) on delete cascade);
create table bankaccount(id int unsigned primary key auto_increment, accountnumber varchar(50) not null, bankname varchar(100), 
	userid int unsigned not null, constraint fk_userid_ba foreign key(userid) references user_details(id) on delete cascade);
