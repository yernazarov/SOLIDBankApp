CREATE TABLE Account
(
    id INTEGER  NOT NULL,
    account_type NVARCHAR(MAX)  NOT NULL,
    client_id NVARCHAR(MAX)  NOT NULL,
    balance FLOAT  NOT NULL,
    withdraw_allowed BIT  NOT NULL,
    CONSTRAINT PK_Account PRIMARY KEY  (id)
);
