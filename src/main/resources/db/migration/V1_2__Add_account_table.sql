CREATE TABLE Account
(
    account_id NVARCHAR(MAX)  NOT NULL,
    account_type NVARCHAR(MAX)  NOT NULL,
    client_id INTEGER  NOT NULL,
    balance FLOAT  NOT NULL,
    withdraw_allowed BIT  NOT NULL,
    CONSTRAINT PK_Account PRIMARY KEY  (account_id),
    FOREIGN KEY (client_id) REFERENCES users(id)
);