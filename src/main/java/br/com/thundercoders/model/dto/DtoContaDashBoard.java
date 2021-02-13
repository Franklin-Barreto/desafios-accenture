package br.com.thundercoders.model.dto;

public class DtoContaDashBoard {

	private Double saldo;
	private Double limite;

	public DtoContaDashBoard(Double saldo, Double limite) {
		this.saldo = saldo;
		this.limite = limite;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimite() {
		return limite;
	}
}
