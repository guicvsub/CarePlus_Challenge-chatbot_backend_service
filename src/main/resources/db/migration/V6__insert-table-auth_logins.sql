-- dialect: mysql

Insert Into auth_logins
(`login`, `senha`, `perfil`)
Values
('ownerLogin', '$2a$10$Rv/IG.5szv5AQDp8TsFbKu8fvZx0r92ig7zznoHPGG4CfF6sxuB7y', 'OWNER'),
('adminLogin', '$2a$10$nGkOrbgR4iGHOPbR/ikPdO.RfhqB/XoH6//lTfjO6Ipmiy2G7iQ36', 'ADMIN'),
('commonLogin', '$2a$10$Riola5Oeo6aNdG7MU11OrexuBSHO7vgOZa8jA3G2OpQbqGheqYODq', 'USER');