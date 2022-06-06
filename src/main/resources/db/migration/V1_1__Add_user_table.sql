CREATE TABLE users
(
    id INTEGER  NOT NULL AUTO_INCREMENT UNIQUE,
    username NVARCHAR(MAX)  NOT NULL UNIQUE,
    password NVARCHAR(MAX)  NOT NULL,
    CONSTRAINT PK_users PRIMARY KEY  (id)
);

INSERT INTO users (username, password) values ('w@a.com', '$2a$16$28myhXGaex5e106VEskTxe3y.ZeaD8E66NUxoV5iO91iZABM0O9SK');