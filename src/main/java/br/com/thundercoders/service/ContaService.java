package br.com.thundercoders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.dto.DtoContaDashBoard;
import br.com.thundercoders.repository.ContaRepository;

@Service
public class ContaService {

	private ContaRepository contaRepository;

	@Autowired
	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	public Conta findById(Integer id) {
		return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário inexistente"));
	}

	public Conta save(Conta conta) {

		return contaRepository.save(conta);
	}

	public Conta findContaByUsuarioId(Integer id) {
		return contaRepository.findByUsuarioId(id);
	}
	
	public DtoContaDashBoard findDashBoard(Integer id) {
		return contaRepository.findDashBoardUsuarioId(id);
	}
}
