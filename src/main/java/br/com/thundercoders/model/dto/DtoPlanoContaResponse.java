package br.com.thundercoders.model.dto;

import br.com.thundercoders.model.PlanoContaTipo;

public class DtoPlanoContaResponse {

	private Integer id;
	private String descricao;
	private PlanoContaTipo tipo;

	public DtoPlanoContaResponse(Integer id, String descricao, PlanoContaTipo tipo) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getTipo() {
		return tipo.getTipo();
	}
}
