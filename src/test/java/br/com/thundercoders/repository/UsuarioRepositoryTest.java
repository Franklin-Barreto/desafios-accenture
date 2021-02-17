package br.com.thundercoders.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.thundercoders.model.Usuario;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;
	private Usuario usuario;

	@BeforeAll
	public void initialize() {
		usuario = repository.save(new Usuario("franklin-barreto", "12345", "Franklin Barreto", "12345678910",null));

	}

	@Order(1)
	@Test
	void salvarUsuario() {

		assertNotNull(usuario.getId());
	}

	@Order(2)
	@Test
	void buscarUsuarioPorIdentificador() {
		Usuario usuario = repository.findById(1).orElseThrow(() -> new RuntimeException("usuário não existe"));
		assertNotNull(usuario);
	}

}
