package br.com.thundercoders.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
class LancamentoRepositoryTest {

	@Autowired
	private LancamentoRepository repository;
	@Autowired
	private UsuarioRepository uRepository;
	@Autowired
	private PlanoContaRepository pRepository;
	@Autowired
	private ContaRepository cRepository;
	private Usuario usuario;
	private Conta conta;
	private Lancamento lancamento;

	@BeforeAll
	public void initialize() {
		this.usuario = uRepository.save(new Usuario("franklin-barreto2", "12345", "Franklin Barreto", "12345678910"));
		this.conta = cRepository.save(new ContaCorrente(usuario, "CC", "2014", 200.0));
		PlanoConta planoConta = pRepository.save(new PlanoConta(usuario, "Farra"));
		this.lancamento = repository.save(new Lancamento(conta, planoConta, 20.0, "Cerveja",
				LocalDateTime.of(2020, 1, 1, 00, 00), LancamentoTipo.DESPESA));
		assertEquals(1, lancamento.getId());
	}

	@Test
	@Order(1)
	 void salvaLancamentoTest() {
		Lancamento lancamento = repository.findById(1).orElseThrow(() -> new RuntimeException("Lancamento não existe"));
		assertNotNull(lancamento);
	}

	@Test
	@Order(2)
	 void buscarLancamentoTest() {
		List<Lancamento> lancamentos = repository.findAllByContaId(conta.getId());
		
		assertTrue(lancamentos.size() > 0);

	}

	@Test
	@Order(3)
	 void buscarLancamentosPorIdContaTest() {
		List<Lancamento> lancamentos = repository.findAllByContaIdAndDataHoraBetween(conta.getId(),
				LocalDateTime.of(2020, 1, 1, 00, 00), // Data
				// Inicio
				LocalDateTime.of(2020, 1, 13, 00, 00));// Data Final
		assertTrue(lancamentos.size() > 0);

	}

}
