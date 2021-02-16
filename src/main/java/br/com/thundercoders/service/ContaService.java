package br.com.thundercoders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thundercoders.exceptions.DashBoardNotFoundException;
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

	public List<Conta> findContaByUsuarioId(Integer id) {
		return contaRepository.findByUsuarioId(id);
	}

	public DtoContaDashBoard findDashBoard(Integer id) {
		return contaRepository.findDashBoardUsuarioId(id)
				.orElseThrow(() -> new DashBoardNotFoundException("Usuário não possue contas"));
	}

	public Conta findByNumero(String contaDestinoNumero) {

		return contaRepository.findByNumero(contaDestinoNumero);
	}

	public List<Conta> findAll() {
		return contaRepository.findAll();
	}
}
