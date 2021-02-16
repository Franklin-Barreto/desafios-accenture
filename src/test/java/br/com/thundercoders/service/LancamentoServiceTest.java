package br.com.thundercoders.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.model.dto.DtoUsuario;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class LancamentoServiceTest {

	@Autowired
	private LancamentoService lancamentoService;
	@Autowired
	private ContaService contaService;
	@Autowired
	private UsuarioService usuarioService;
	private Usuario usuario;
	private Conta conta;
	private Conta contaDestino;

	@BeforeAll
	public void initialize() {
		this.usuario = this.usuarioService
				.save(new DtoUsuario("joao.pedro", "14587", "João Pedro", "45896578412", 200.0));
		this.conta = this.usuarioService.findContaUsuario(1).stream().findFirst().get();
		this.contaDestino = contaService.save(new ContaCorrente(usuario,  400.0));
	}

	@Test
	@Order(1)
	void salvaLancamento() {
		System.out.println("buscada no banco "+conta.getSaldo());
		Lancamento salvaLancamento = this.lancamentoService.salvaLancamento(new DtoLancamento(1,1, 100.0, "Teste", LocalDateTime.now(), LancamentoTipo.RECEITA));
	//	assertEquals(600, salvaLancamento.getConta().getSaldo());
		assertNotNull(salvaLancamento);
	}

	@Test
	@Order(2)
	void salvaLancamentoDespesa() {

		Lancamento salvaLancamento = this.lancamentoService.salvaLancamento(new DtoLancamento(conta.getId(),
				1, 50.0, "Almoço", LocalDateTime.now(), LancamentoTipo.DESPESA));
		assertNotNull(salvaLancamento);
	//	assertEquals(350.0, salvaLancamento.getConta().getSaldo());

	}

	@Test
	@Order(3)
	void salvaLancamentoTransferencia() {
	
		Lancamento salvaLancamento = this.lancamentoService
				.salvaLancamento(new DtoLancamento(1, ((ContaCorrente)contaDestino).getNumero(), 1, 50.0,
						"Almoço", LocalDateTime.now(), LancamentoTipo.TRANSFERENCIA));
		assertNotNull(salvaLancamento);
	//	assertEquals(450.0, salvaLancamento.getConta().getSaldo());
	//	assertEquals(450.0, salvaLancamento.getContaDestino().getSaldo());

	}
}
