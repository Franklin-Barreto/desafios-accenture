INSERT INTO usuario (login,senha,nome,cpf) VALUES ('franklin-barreto', '$2y$12$jNe3kBI7yejxsKLZmSjcT.KL8QcBYKTkyH2QmRKf7pEHToyjHi1AG', 'Franklin Barreto', '12345678910');
INSERT INTO usuario (login,senha,nome,cpf) VALUES ('joao.pedro','45dfadfa','João Pedro','15679879879');
INSERT INTO  conta (id_usuario) VALUES (1);
INSERT INTO conta_corrente (numero,saldo,tipo,id) VALUES ('154-x',500.0,'CORRENTE',1);
INSERT INTO plano_conta (descricao,id_usuario) VALUES ('viagem',1)