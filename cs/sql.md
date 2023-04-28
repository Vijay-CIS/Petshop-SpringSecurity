
```sql
use petshop_db;
show tables;
```

#### User Module

```sql
drop table USER_ROLE;
 CREATE TABLE user (
USERID BIGINT(5) NOT NULL AUTO_INCREMENT,
USERNAME VARCHAR(100) NOT NULL UNIQUE,
USERPASSWORD VARCHAR(100) NOT NULL,
PRIMARY KEY (USERID)
);

drop table USER;
drop table ROLE;

  create table user_role (
    userroleid int primary key auto_increment,
  roleid int not null,
  userid bigint not null 
  );  
  
  insert into ROLE values (1,'ADMIN');
  insert into ROLE values (2,'USER');
  
  select * from USER;

```

#### Pet Module

```sql
drop table pet;
  create table role (
  roleid int primary key auto_increment,
  name varchar(100) not null unique
  );

 CREATE TABLE pet (
PETID INT(5) NOT NULL AUTO_INCREMENT,
PETNAME VARCHAR(55) NOT NULL,
PETAGE INT(2),
PETPLACE VARCHAR(55),
PETOWNERID BIGINT NULL,
FOREIGN KEY (PETOWNERID)
REFERENCES USER(userid)
ON DELETE CASCADE,
PRIMARY KEY (PETID)
);
```
