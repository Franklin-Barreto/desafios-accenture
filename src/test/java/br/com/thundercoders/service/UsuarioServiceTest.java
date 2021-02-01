package br.com.thundercoders.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import br.com.thundercoders.model.ContaTipo;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoUsuario;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService usuarioService;

	@Test
	@Order(1)
	public void salvaUsuario() throws IllegalAccessException {
		Usuario save = usuarioService.save(new DtoUsuario("guilherme.lima", "14587", "Guilherme Lima", "45896578412",ContaTipo.CONTACREDITO,600.0));
		assertNotNull(save);
	}

	@Test

	@Order(2)
	public void salvaUsuario2() throws IllegalAccessException {
		Usuario usuario = this.usuarioService.save(new DtoUsuario("igor.shimauti", "56789", "Igor Shimauti", "36285117802",ContaTipo.CONTACREDITO,700.0));
		assertNotNull(usuario);
	}

	@Test

	@Order(3)
	public void buscarPorId() {
		Usuario usuario = this.usuarioService.findById(1);
		assertNotNull(usuario);
	}

	@Test

	@Order(4)
	public void buscarTodos() {
		List<Usuario> usuarios = this.usuarioService.findAll();
		assertTrue(usuarios.size() > 0);
	}

}