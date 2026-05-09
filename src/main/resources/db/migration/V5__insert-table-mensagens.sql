-- dialect: mysql

Insert Into mensagens
(`role`, `content`, `data_hora`, `usuario_id`)
Values
('user', 'Olá? Tudo Bem?','2026-05-01 10:30:00', 1),
('system', 'Tudo certo! Como Vai?', '2026-05-01 10:30:01', 1),
('user', '.', '2026-06-02 11:00:04', 2),
('system', 'Olá? Sobre o que gostaria de conversar?', '2026-06-02 11:00:05', 2),
('user', 'Poderia me falar sobre os planos de saúde disponíveis?', '2026-06-02 11:00:06', 2),
('system', 'Claro que sim! Aqui vai uma lista de planos disponíveis da Care Plus:\n- Care Plus Soho(Para 10 a 29 vidas)\n- Clube Care Plus(Para 30 a 200 vidas)\n- Care Plus Empresarial(Para mais de 200 vidas)', '2026-06-02 11:00:07', 2),
('user', 'Oi', '2026-08-03 15:30:11', 3),
('system', 'Oi! Em que poderia ajudar?', '2026-08-03 15:30:12', 3);