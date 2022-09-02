create table animals (idno int, name varchar(255), origin varchar(255),PRIMARY KEY (idno));

insert into animals values(1,'Lion','Africa');
insert into animals values(2,'Cheetah','Africa');
insert into animals values(3,'Elephant','Africa');
insert into animals values(4,'Zebra','Africa');
insert into animals values(5,'Hippo','Africa');
insert into animals values(6,'Penguin','Antarctica');
insert into animals values(7,'Whale','Antarctica');
insert into animals values(8,'Panda','Asia');
insert into animals values(9,'Pangolin','Asia');
insert into animals values(10,'Tiger','Asia');


Create table zookeeper (empid int, name varchar(255), salary int, PRIMARY KEY (empid));
Insert into zookeeper values(1, “Bob”, 50000);
Insert into zookeeper values(2, “Rick”, 50000);
Insert into zookeeper values(3, “Zack”, 40000);
Insert into zookeeper values(4, “Jess”, 60000);
Insert into zookeeper values(5, “Pete”, 35000);

Create table assignments(asgno int, empid int, animalid int, PRIMARY KEY (asgno));
Insert into assignments values(1,1,1);
Insert into assignments values(2,1,2);
Insert into assignments values(3,2,3);
Insert into assignments values(4,2,4);
Insert into assignments values(5,2,5);
Insert into assignments values(6,3,6);
Insert into assignments values(7,3,7);
Insert into assignments values(8,4,8);
Insert into assignments values(9,4,9);
Insert into assignments values(10,5,10);















