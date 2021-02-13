package br.com.thundercoders.model;

import javax.persistence.*;

@Entity
public class PlanoConta extends EntidadeBase {

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	@Column(name = "descricao", length = 100)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private PlanoContaTipo tipo;

	public PlanoConta() {
	}

	public PlanoConta(Usuario usuario, String descricao) {
		this.usuario = usuario;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public PlanoContaTipo getTipo() {
		return tipo;
	}
}
