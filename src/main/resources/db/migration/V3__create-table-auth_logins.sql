-- dialect:mysql

Create Table auth_logins(
    id              BigInt          Not Null    Auto_increment,
    login           VarChar(100)    Not Null    Unique,
    senha           VarChar(255)    Not Null,
    perfil          VarChar(10)     Not Null,
    Primary Key(id)
);