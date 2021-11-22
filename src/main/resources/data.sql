
INSERT INTO PESSOAS(nome, cpf, data_nascimento) VALUES('Dock-teste', '000000000-00', now());
INSERT INTO PESSOAS(nome, cpf, data_nascimento) VALUES('Rafael-teste', '123456789-00', '1993-06-04');

INSERT INTO CONTAS(pessoa_id_pessoa, tipo_conta, saldo, limite_saque_diario, flag_ativo, data_criacao) VALUES(1, 2, 9800.53, 100.45, true, now());
INSERT INTO CONTAS(pessoa_id_pessoa, tipo_conta, saldo, limite_saque_diario, flag_ativo, data_criacao) VALUES(2, 4, 560.10, 200.00, false, now());

/*INSERT INTO TRANSACOES(conta_id_conta, valor, data_transacao) VALUES(1, 1.99, now());
INSERT INTO TRANSACOES(conta_id_conta, valor, data_transacao) VALUES(2, 5.50, now());*/





