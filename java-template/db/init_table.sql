#Configuration tables
drop table if exists exception_code;
create table exception_code (
    class varchar(255) not null,
    code  varchar(10) not null,
    primary key(class, code)
);

#Authentication tables
drop table if exists users;
create table users (
    username varchar(20) not null,
    password varchar(20) not null,
    email varchar(20),
    phone varchar(10),
    create_time datetime not null,
    primary key(username)
);

drop table if exists roles;
create table roles (
    role varchar(20) not null,
    is_temp int(1) not null default 0,
    remark varchar(255),
    primary key(role)
);

drop table if exists user_role;
create table user_role (
    id int(10) AUTO_INCREMENT,
    username varchar(20),
    role varchar(20),
    primary key(id),
    FOREIGN KEY(username) REFERENCES users(username),
    FOREIGN KEY(role) REFERENCES roles(role)
);

insert into exception_code values ('com.template.exception.InvalidRequestException', '10001');
insert into users (username, password, create_time) values ('admin', 'admin', current_timestamp());
insert into roles values ('admin', 0, '');
insert into user_role (username, role) values ('admin', 'admin');

create table model2 (field1 VARCHAR(20), double(10,2));
