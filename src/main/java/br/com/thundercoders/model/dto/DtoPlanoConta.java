package br.com.thundercoders.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.PlanoContaTipo;

public class DtoPlanoConta {

	@Min(1)
	private Integer usuarioId;

	@NotNull
	private String descricao;

	private Integer tipo;

	public DtoPlanoConta(Integer usuarioId, String descricao, Integer tipo) {
		this.usuarioId = usuarioId;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTipo() {
		PlanoContaTipo planoContaTipo = PlanoContaTipo.valueOf(tipo);
		return planoContaTipo.toString();
	}

	public DtoPlanoConta converter(PlanoConta planoConta) {
		return new DtoPlanoConta(planoConta.getUsuario().getId(), planoConta.getDescricao(),
				planoConta.getTipo().getTipo());
	}

}
