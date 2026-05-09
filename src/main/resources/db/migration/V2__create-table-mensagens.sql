-- dialect:mysql

Create Table mensagens(
    id              BigInt          Not Null    Auto_increment,
    role            VarChar(6)      Not Null,
    content         VarChar(255)    Not Null,
    data_hora       DateTime        Not Null    Default Current_Timestamp,
    usuario_id     BigInt          Not Null,
    Primary Key(id),
    Constraint      mensagem_usuario_FK     Foreign Key(usuario_id)    References usuarios(id)
);