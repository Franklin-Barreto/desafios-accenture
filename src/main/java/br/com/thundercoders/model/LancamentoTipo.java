package br.com.thundercoders.model;

import br.com.thundercoders.service.ContaService;
import br.com.thundercoders.service.Despesa;
import br.com.thundercoders.service.OperacaoI;
import br.com.thundercoders.service.Receita;
import br.com.thundercoders.service.Transferencia;

public enum LancamentoTipo {

	DESPESA(new Despesa()), RECEITA(new Receita()), TRANSFERENCIA(new Transferencia());

	private OperacaoI operacao;

	private LancamentoTipo(OperacaoI operacao) {
		this.operacao = operacao;
	}

	public void setService(ContaService service) {
		this.operacao.setService(service);
	}

	public OperacaoI getOperacao() {
		return operacao;
	}
}
