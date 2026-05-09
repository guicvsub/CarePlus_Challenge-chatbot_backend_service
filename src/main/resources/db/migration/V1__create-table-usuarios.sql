-- dialect:mysql

Create Table usuarios(
    id              BigInt          Not Null    Auto_increment,
    celular         VarChar(13)     Not Null    Unique,
    ativo           TinyInt         Not Null    Default 1,
    Primary Key(id)
);