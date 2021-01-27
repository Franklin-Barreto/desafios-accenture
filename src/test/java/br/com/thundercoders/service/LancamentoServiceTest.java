package br.com.thundercoders.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.thundercoders.model.Lancamento;
import br.com.thundercoders.model.LancamentoTipo;
import br.com.thundercoders.model.dto.DtoLancamento;
import br.com.thundercoders.repository.ContaRepository;
import br.com.thundercoders.repository.LancamentoRepository;
import br.com.thundercoders.repository.PlanoContaRepository;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.ConexaoFactory;

class LancamentoServiceTest {
	private LancamentoService lancamentoService;
	private LancamentoRepository lancamentoRepository;
	private ContaService contaService;
	private PlanoContaService planoContaService;
	private EntityManager em;
	private ContaRepository contaRepository;
	private UsuarioService usuarioService;
	private PlanoContaRepository planoContaRepository;
	private UsuarioRepository usuarioRepository; 
	
	@BeforeEach
	public void initialize() {
		this.em = ConexaoFactory.getConexao();
		this.contaRepository = new ContaRepository(em);
		this.usuarioRepository = new UsuarioRepository(em);
		this.usuarioService = new UsuarioService(usuarioRepository);
		this.planoContaRepository = new PlanoContaRepository(em);
		this.lancamentoRepository = new LancamentoRepository(em);
		this.contaService = new ContaService(contaRepository);
		this.planoContaService = new PlanoContaService(usuarioService, planoContaRepository);
		lancamentoService = new LancamentoService(lancamentoRepository, contaService, planoContaService);
	}
	
	@Test
	void salvaLancamento() {
		Lancamento salvaLancamento = this.lancamentoService.salvaLancamento(new DtoLancamento(1, 1, 100.0, "Teste", LocalDateTime.now(), LancamentoTipo.CREDITO));
		System.out.println("Teste " + salvaLancamento.getId());
		assertEquals(1, salvaLancamento.getId());
	}
}
