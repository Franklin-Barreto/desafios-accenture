package br.com.thundercoders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.PlanoContaTipo;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoPlanoConta;
import br.com.thundercoders.model.dto.DtoPlanoContaResponse;
import br.com.thundercoders.repository.PlanoContaRepository;

@Service
public class PlanoContaService {

	private UsuarioService usuarioService;
	private PlanoContaRepository planoContaRepository;

	@Autowired
	public PlanoContaService(UsuarioService usuarioService, PlanoContaRepository planoContaRepository) {
		this.usuarioService = usuarioService;
		this.planoContaRepository = planoContaRepository;
	}

	public PlanoConta salvaPlanoConta(DtoPlanoConta dtoPlanoConta) {
		Usuario usuario = usuarioService.findById(dtoPlanoConta.getUsuarioId());
		return planoContaRepository.save(new PlanoConta(usuario, dtoPlanoConta.getDescricao(),PlanoContaTipo.valueOf(dtoPlanoConta.getTipo())));
	}

	public PlanoConta findById(Integer id) {
		return planoContaRepository.findById(id).orElseThrow(() -> new RuntimeException("Plano de conta inexistente"));
	}

	public List<DtoPlanoContaResponse> findAllByTipo(Integer tipo) {
		return planoContaRepository.findAllByTipo(PlanoContaTipo.valueOf(tipo));
	}
	
	public List<DtoPlanoContaResponse> findAll(){
		return planoContaRepository.findAllPlanoConta();
	}

}
