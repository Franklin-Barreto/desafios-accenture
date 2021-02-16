package br.com.thundercoders.service;

import br.com.thundercoders.model.Conta;

public class Receita implements OperacaoI {

	@Override
	public Conta efetuarOperacao(Double valor, Conta... contas) {
		contas[0].creditar(valor);
		return null;
	}
}
