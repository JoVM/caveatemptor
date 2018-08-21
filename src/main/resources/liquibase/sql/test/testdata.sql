--liquibase formatted sql
--changeset amudhan:1
--Initial data
insert into category(id, name)values(10000000, 'book'),(10000001, 'electronics');
insert into category(id, name, parentid)values(10000002,'Paperback',10000000),(10000003,'ebook',10000000),(10000004,'hardcover',10000000),(10000005,'phone',10000002),(10000006,'mobile phone',10000002);
insert into user_details (id, firstname, lastname, usertype) values(10000001, 'James', 'Bond', 'BUYER'),(10000002, 'Jon', 'Snow', 'SELLER'),(10000003, 'Nikola', 'Tesla', 'BUYER'),
	(10000004, 'Robin','Hood','SELLER'),(10000005, 'Arya','Stark','BUYER');
insert into user_details (id, firstname, lastname, usertype) values (10000006, 'Rob','Stark','SELLER'),(10000007, 'Jon','Aryn','BUYER');
insert into item (id, name, initialprice,description, sellerid, categoryid) values(10000001, 'Kindle e book reader', 6000, 'An awesome reader', 10000002, 10000001),
	(10000002, 'Steve Jobs', 400, 'The life of Steve Jobs', 10000004, 10000000),(10000003, 'Dell XPS',5000,'A high end laptop',10000004,10000001);
insert into item (id, name, initialprice,description, sellerid, categoryid) values(10000004, 'Lenovo', 12000, 'A good phone', 10000002, 10000001);
insert into image(id, name, imageurl, itemid)values(10000001, 'Book about steve jobs','/resources/images/thelifeofjobs.jpg',10000002),
	(10000002, 'Dell laptop','/resources/images/dellxps.jpg',10000003),(10000003, 'Kindle ebook reader','/resources/images/kindleebookreader.jpg',10000002);
insert into address(id, addresstype, building, city, street, zipcode, userid)
	values (10000001, 'HOME','12, ABHomes','Chennai','Max street','11',10000001),(10000002, 'BILLING','33, Ferret appartment','Mumbai','Maximum street','22',10000001), 
			(10000003, 'BILLING','436, EE Homes','Engineer avenue Chennai','Supreme street','12', 10000002),(10000004, 'HOME','46, EE Homes','Engineer avenue Chennai','Supreme street','12', 10000002),
            (10000005, 'BILLING','1B, A Apartments','AB avenue Delhi','XZ street','89', 10000003),(10000006, 'HOME','343, JI Homes','Spacefeast avenue Chennai','Super muggle street','77', 10000003),
            (10000007, 'BILLING','36, Plot 78','May avenue Mumbai','KS','56', 10000004),(10000008, 'HOME','36, Plot 78','May avenue Mumbai','KS','56', 10000004),
            (10000009, 'BILLING','432, First floor, Victoria gated community','XP avenue Kochin','KI street','34', 10000005),(10000010, 'HOME','432, First floor, Victoria gated community','XP avenue Kochin','KI street','34', 10000005);
insert into bid(id, amount, createdon, itemid, bidderid) values(10000001, 6500, now(), 10000001, 10000001),(10000002, 6501, now(), 10000001, 10000002),(10000003, 6301, now(), 10000001, 10000003),(10000004, 6302, now(), 10000001, 10000003),
	(10000005, 300, now(), 10000002, 10000004),(10000006, 301, now(), 10000002, 10000005),(10000007, 350, now(), 10000002, 10000001);
set @accountnumber='123';
set @count=4;
set @bankname='Bank1';
set @accountid=10000000;
insert into bankaccount(id, accountnumber, bankname, userid)select @accountid:=@accountid+1 as id, concat(@accountnumber,@count:=@count+1) as accountnumber, 
	concat(@bankname,@count:=@count+1) as bankname, id as userid from user_details;
set @ccnumber='321';
set @ccount='4';
set @exmonth='1';
set @exyear='2018';
set @ccid=10000000;
insert into creditcard(id, creditcardnumber, expirymonth, expiryyear, userid)select @ccid:=@ccid+1 as id, concat(@ccnumber,@ccount:=@count+1) as creditcardnumber, 
	(@exmonth:=@exmonth+1)as expirymonth,(@exyear:=@exyear+1)as exyear, id as userid from user_details;