package br.com.thundercoders.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.LancamentoRepository;

@Service
public class LancamentoService {

	private ContaService contaService;
	private PlanoContaService planoContaService;
	private LancamentoRepository lancamentoRepository;

	@Autowired
	public LancamentoService(LancamentoRepository lancamentoRepository, ContaService contaService,
			PlanoContaService planoContaService) {
		this.contaService = contaService;
		this.planoContaService = planoContaService;
		this.lancamentoRepository = lancamentoRepository;

	}

	public Lancamento salvaLancamento(DtoLancamento dtoLancamento) {
		LancamentoTipo lancamentoTipo = dtoLancamento.getLancamentoTipo();
		Conta conta = contaService.findById(dtoLancamento.getContaId());
		Conta contaDestino = dtoLancamento.getContaDestinoNumero() != null
				? contaService.findByNumero(dtoLancamento.getContaDestinoNumero())
				: null;

		PlanoConta planoConta = null;

		if (dtoLancamento.getPlanoContaId() != null) {

			planoConta = planoContaService.findById(dtoLancamento.getPlanoContaId());
		}
		Lancamento lancamento = new Lancamento(conta, planoConta, dtoLancamento.getValor(),
				dtoLancamento.getDescricao(), dtoLancamento.getDataHora(), dtoLancamento.getLancamentoTipo());

		contaDestino = lancamentoTipo.getOperacao().efetuarOperacao(dtoLancamento.getValor(), conta, contaDestino);
		if (contaDestino != null) {
			lancamentoRepository.save(new Lancamento(contaDestino, null, dtoLancamento.getValor(),
					"Transferencia conta " + ((ContaCorrente) conta).getNumero(), dtoLancamento.getDataHora(), LancamentoTipo.RECEITA));
		}
		lancamento.setContaDestino(contaDestino);
		return lancamentoRepository.save(lancamento);
	}

	public List<DtoLancamento> buscarLancamentoPorConta(Integer idConta) {

		List<Lancamento> lancamentos = lancamentoRepository.findAllByContaId(idConta);

		return lancamentos.stream().map(l -> new DtoLancamento(l)).collect(Collectors.toList());
	}

	public List<DtoLancamento> buscarPorPeriodoEIdConta(Integer idConta, LocalDateTime dataInicial,
			LocalDateTime dataFinal) {
		return lancamentoRepository.findAllByContaIdAndDataHoraBetween(idConta, dataInicial, dataFinal).stream()
				.map(l -> new DtoLancamento(l)).collect(Collectors.toList());
	}

}
