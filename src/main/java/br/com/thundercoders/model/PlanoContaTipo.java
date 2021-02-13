package br.com.thundercoders.model;

import java.util.HashMap;
import java.util.Map;

public enum PlanoContaTipo {

	RECEITA(1), DESPESA(2);

	private int tipo;
	private static Map<Integer, PlanoContaTipo> map = new HashMap<>();

	PlanoContaTipo(int tipo) {
		this.tipo = tipo;
	}

	static {
		
		for (PlanoContaTipo plano : PlanoContaTipo.values()) {
			map.put(plano.tipo, plano);
		}
	}

	public static PlanoContaTipo valueOf(int tipo) {
		return map.get(tipo);
	}

	public int getTipo() {
		return tipo;
	}
}
