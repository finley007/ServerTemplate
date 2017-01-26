#Authentication tables
drop table if exists user;
create table user (
    username varchar(20) not null,
    password varchar(20) not null,
    email varchar(20),
    phone varchar(10),
    create_time datetime not null,
    primary key(username)
);

insert into user (username, password, create_time) values ('admin', 'admin', current_timestamp());

create table model2 (field1 VARCHAR(20), double(10,2));
