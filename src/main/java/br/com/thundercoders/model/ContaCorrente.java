package br.com.thundercoders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ContaCorrente extends Conta {

	@Transient
	private static byte digito = 0;

	@Column(name = "numero")
	private String numero;

	@Column(name = "saldo")
	private Double saldo;

	public ContaCorrente() {
	}

	public ContaCorrente(Usuario usuario, Double saldo) {
		super(usuario);
		if (digito == 9) {
			digito = 0;
		}
		this.numero = getQuatroNumeros() + "-" + digito++;
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public Double getSaldo() {
		return saldo;
	}

	@Override
	public void debitar(Double valor) {
		this.saldo -= valor;
	}

	@Override
	public void creditar(Double valor) {
		this.saldo += valor;
	}

	@Override
	public void transferir(Double valor, Conta contaDestino) {
		this.debitar(valor);
		contaDestino.creditar(valor);
	}

}
