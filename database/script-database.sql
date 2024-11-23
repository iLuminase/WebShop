CREATE DATABASE springbootwebshop character set UTF8 collate utf8_bin;

use springbootwebshop;
insert into hello(content) values('Hello Laptrinhjavaweb');
select * from hello;


CREATE TABLE role(
                     id bigint NOT NULL PRIMARY KEY auto_increment,
                     name VARCHAR(255) NOT NULL,
                     code VARCHAR(255) NOT NULL,
                     createddate TIMESTAMP NULL,
                     modifieddate TIMESTAMP NULL,
                     createdby VARCHAR(255) NULL,
                     modifiedby VARCHAR(255) NULL
);

CREATE TABLE user (
                      id bigint NOT NULL PRIMARY KEY auto_increment,
                      username VARCHAR(150) NOT NULL,
                      password VARCHAR(150) NOT NULL,
                      fullname VARCHAR(150) NULL,
                      status int NOT NULL,
                      roleid bigint NOT NULL,
                      createddate TIMESTAMP NULL,
                      modifieddate TIMESTAMP NULL,
                      createdby VARCHAR(255) NULL,
                      modifiedby VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);

insert into role(code,name) values('ADMIN','ADMIN');
insert into role(code,name) values('USER','USER');

insert into user(username,password,fullname,status, roleid) values('admin','123456','admin',1,1);
insert into user(username,password,fullname,status, roleid) values('nguyenvana','123456','nguyen van a',1,2);
insert into user(username,password,fullname,status, roleid) values('nguyenvanb','123456','nguyen van b',1,2);