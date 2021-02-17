package br.com.thundercoders.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.Usuario;
@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
 class ContaRepositoryTest {

	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;


	@Test
	 void salvaConta() {
		Usuario usuario = usuarioRepository.save(new Usuario("joao.joaquim","123456", "joao", "1234567890",null));
		Conta conta = contaRepository.save(new ContaCorrente(usuario,  200.0));
		assertNotNull(conta);
	}
	

}
