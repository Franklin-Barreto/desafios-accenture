package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;

public class Despesa implements OperacaoI {

	@Override
	public Conta efetuarOperacao(Double valor, Conta... contas) {
		contas[0].debitar(valor);
		return null;
	}

}
