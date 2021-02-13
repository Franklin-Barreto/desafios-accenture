package br.com.thundercoders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thundercoders.model.ContaCredito;
import br.com.thundercoders.model.dto.DtoContaDashBoard;
import br.com.thundercoders.service.ContaService;

@CrossOrigin
@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@PostMapping
	public void novaContaCredito(@RequestBody ContaCredito contaCredito) {
		contaService.save(contaCredito);
	}

	@GetMapping("/dashboard/{id}")
	public ResponseEntity<DtoContaDashBoard> dashBoard(@PathVariable Integer id) {
		return ResponseEntity.ok(contaService.findDashBoard(id));

	}

}
