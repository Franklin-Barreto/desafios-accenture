INSERT INTO usuario (login,senha,nome,cpf) VALUES ('franklin-barreto@hotmail.com', '$2y$12$jNe3kBI7yejxsKLZmSjcT.KL8QcBYKTkyH2QmRKf7pEHToyjHi1AG', 'Franklin Barreto', '12345678910');
INSERT INTO usuario (login,senha,nome,cpf) VALUES ('joao.pedro@hotmail.com','$2y$12$jNe3kBI7yejxsKLZmSjcT.KL8QcBYKTkyH2QmRKf7pEHToyjHi1AG','João Pedro','15679879879');
INSERT INTO  conta (id_usuario) VALUES (1);
INSERT INTO conta_corrente (numero,saldo,tipo,id) VALUES ('154-x',480.0,'CORRENTE',1);
INSERT INTO conta_credito (cvv,limite,nome_impresso,numero_cartao,id) VALUES ('555',500.0,'Franklin Barreto',548154784522,1);
INSERT INTO plano_conta (descricao,id_usuario,tipo) VALUES ('viagem',1,'RECEITA');
INSERT INTO plano_conta (descricao,id_usuario,tipo) VALUES ('carro',1,'DESPESA')