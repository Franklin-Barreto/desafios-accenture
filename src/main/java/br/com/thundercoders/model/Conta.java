package br.com.thundercoders.model;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Conta extends EntidadeBase {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	@Transient
	private Random rand = new Random();

	public Conta() {
	}

	public Conta(Usuario usuario) {
		this.usuario = usuario;
	}

	public abstract void debitar(Double valor);

	public abstract void creditar(Double valor);

	public abstract void transferir(Double valor, Conta contaDestino);

	public abstract Double getSaldo();

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	protected int getQuatroNumeros() {
		return rand.ints(1000, 9999).findFirst().getAsInt();
	}
	
	protected Random getRand() {
		return rand;
	}

}
