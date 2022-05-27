CREATE TABLE Transaction
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    account_id INTEGER NOT NULL ,
    amount FLOAT  NOT NULL,
    type NVARCHAR(MAX)  NOT NULL,
    CONSTRAINT PK_Transaction PRIMARY KEY  (id),
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);