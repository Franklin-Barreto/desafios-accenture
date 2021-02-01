package br.com.thundercoders.controller;

import java.math.BigInteger;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.service.LancamentoService;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

	private LancamentoService lancamentoService;

	public LancamentoController(LancamentoService lancamentoService) {
		this.lancamentoService = lancamentoService;
	}

	@PostMapping
	public ResponseEntity<DtoLancamento> salvarLancamento(@RequestBody DtoLancamento dtoLancamento,
			UriComponentsBuilder uriBuilder) {

		Lancamento lancamentoSalvo = lancamentoService.salvaLancamento(dtoLancamento);
		Integer planoContaId = null;
		URI uri = uriBuilder.path("lancamento/{id}").buildAndExpand(lancamentoSalvo.getId()).toUri();

		if (lancamentoSalvo.getPlanoConta() != null) {
			planoContaId = lancamentoSalvo.getPlanoConta().getId();
		}

		DtoLancamento lancamentoDto = new DtoLancamento(lancamentoSalvo.getConta().getId(), planoContaId,
				lancamentoSalvo.getValor(), lancamentoSalvo.getDescricao(), lancamentoSalvo.getDataHora(),
				lancamentoSalvo.getLancamentoTipo());
		return ResponseEntity.created(uri).body(lancamentoDto);
	}

	@GetMapping("{idConta}")
	public ResponseEntity<List<DtoLancamento>> buscarLancamentoPorConta(@PathVariable("idConta") Integer idConta) {

		try {
			return ResponseEntity.ok(lancamentoService.buscarLancamentoPorConta(idConta));
		}catch (Exception ee) {
			return null;
		}
	}

	@GetMapping("porPeriodo/{idConta}")
	public ResponseEntity<List<DtoLancamento>> buscarLancamentoPorPeriodoEConta(@PathVariable("idConta") Integer idConta, @RequestParam LocalDateTime dataInicial,
																		  @RequestParam LocalDateTime dataFinal) {

		try {
			return ResponseEntity.ok(lancamentoService.buscarPorPeriodoEIdConta(idConta,dataInicial,dataFinal));
		}catch (Exception ee) {
			return null;
		}
	}

}
