package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;

public class Transferencia implements OperacaoI {

	@Override
	public Conta efetuarOperacao(Double valor, Conta... contas) {
		contas[0].debitar(valor);
		contas[1].creditar(valor);
		return contas[1];
	}
}
