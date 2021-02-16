package br.com.thundercoders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCredito;
import br.com.thundercoders.model.dto.DtoContaDashBoard;
import br.com.thundercoders.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@CrossOrigin
	@PostMapping
	public void novaContaCredito(@RequestBody ContaCredito contaCredito) {
		contaService.save(contaCredito);
	}

	@CrossOrigin
	@GetMapping("/dashboard/{id}")
	public ResponseEntity<DtoContaDashBoard> dashBoard(@PathVariable Integer id) {
		return ResponseEntity.ok().body(contaService.findDashBoard(id));
	}

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Conta>> contas() {
		return ResponseEntity.ok(contaService.findAll());
	}

	@CrossOrigin
	@GetMapping("/usuario/{id}")
	public ResponseEntity<List<Conta>> contasIdUsuario(@PathVariable Integer id) {
		return ResponseEntity.ok(contaService.findContaByUsuarioId(id));
	}

}
