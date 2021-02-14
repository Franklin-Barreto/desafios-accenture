package br.com.thundercoders.model;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ContaCredito extends Conta {

	@Column(name = "numero_cartao")
	private String numeroCartao;

	@Column(name = "nome_impresso")
	private String nomeImpresso;

	@Column(name = "cvv")
	private String cvv;

	@Column(name = "limite")
	private Double limite;

	public ContaCredito() {
	}

	public ContaCredito(Usuario usuario) {
		super(usuario);
		nomeImpresso = usuario.getNome();
		numeroCartao = getQuatroNumeros() + " " + getQuatroNumeros() + " " + getQuatroNumeros() + " "
				+ getQuatroNumeros();
		cvv = String.valueOf(getRand().ints(100, 999).findFirst().getAsInt());
	}

	@Override
	public void debitar(Double valor) {
		this.limite -= valor;
	}

	@Override
	public void creditar(Double valor) {
		this.limite += valor;
	}

	@Override
	public void transferir(Double valor, Conta contaDestino) {
		this.limite -= valor;
		contaDestino.creditar(valor);
	}

	@Override
	public Double getSaldo() {
		return limite;
	}

}
