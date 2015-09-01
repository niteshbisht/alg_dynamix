show databases;
use sqlpract;

create table tree(col1 varchar(30),col2 varchar(30),col3 varchar(30),col4 varchar(30),col5 varchar(30),col6 varchar(30),col7 varchar(30));
truncate table tree;
select * from tree;

insert into tree values ('Bussiness Group','Information System','Info Sec Group','Authentication Group','Datacenter Group','Certificate Group','Tokens Group');
insert into tree values ('Bussiness Group','Information System','Info Sec Group','Authentication Group','DatawareHouse Group','Certificate Group','Tokens Group');
insert into tree values ('Bussiness Group','Information System','Info Sec Admin','Authentication Group','Facilities Group','Certificate Group','Tokens Group');
insert into tree values ('Wealth Management','Information System','Infrastructure Team','Store Team','Network Team','Finance Team','Records Team');
insert into tree values ('Wealth Management','Parallel System','SSL Support Team','Device Support','Helpdesk Team','24x7 Support Team','Routing Support');
0.912493 millisecs