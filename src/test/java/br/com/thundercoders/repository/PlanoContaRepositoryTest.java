package br.com.thundercoders.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.Usuario;

@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
class PlanoContaRepositoryTest {

	@Autowired
	private PlanoContaRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	private Usuario usuario;

	@Test
	@Order(1)
	void salvarPlanoContasTest() {
		this.usuario = usuarioRepository.findById(1)
				.orElseThrow(() -> new RuntimeException("Erro plano de conta repository"));
		PlanoConta save = repository.save(new PlanoConta(usuario, "Pagamento de salário"));
		assertNotNull(save.getId());
	}

	@Test
	@Order(2)
	void salvarPlanoContasTest2() {
		this.usuario = usuarioRepository.findById(2)
				.orElseThrow(() -> new RuntimeException("Erro plano de conta repository"));
		PlanoConta save = repository.save(new PlanoConta(usuario, "Pagamento de salário"));
		assertNotNull(save.getId());
	}
}
