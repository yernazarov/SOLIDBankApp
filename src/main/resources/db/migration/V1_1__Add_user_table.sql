
CREATE TABLE roles
(
    id INTEGER  NOT NULL AUTO_INCREMENT UNIQUE,
    name NVARCHAR(20)  NOT NULL,
    CONSTRAINT PK_roles PRIMARY KEY (id)
);

insert into roles(name) values ('ROLE_ADMIN');
insert into roles(name) values ('ROLE_USER');

CREATE TABLE users
(
    id INTEGER  NOT NULL AUTO_INCREMENT UNIQUE,
    username NVARCHAR(MAX)  NOT NULL UNIQUE,
    password NVARCHAR(MAX)  NOT NULL,
    role_id INTEGER,
    CONSTRAINT PK_users PRIMARY KEY  (id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);