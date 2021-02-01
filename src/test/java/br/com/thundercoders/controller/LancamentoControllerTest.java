package br.com.thundercoders.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.thundercoders.config.TokenService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class LancamentoControllerTest {

	private String token;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AuthenticationManager authManager;

	@BeforeAll
	public void initialize() throws URISyntaxException, Exception {
		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken("franklin-barreto", "12345"));
		token = tokenService.gerarToken(auth);
		System.out.println("Token " + token);
	}

	@Test
	void salvaLancamentoControllerTest() throws Exception {
		String json = "{\r\n" + "   \"contaId\" : 1,\r\n" + "   \"planoContaId\" : 1,\r\n"
				+ "   \"valor\" : \"250.0\",\r\n" + "   \"descricao\" : \"empréstimo pago de volta\",\r\n"
				+ "   \"dataHora\" : null,\r\n" + "   \"lancamentoTipo\" : \"RECEITA\",\r\n"
				+ "   \"contaDestinoId\":null\r\n" + "\r\n" + "}";
		URI uri = new URI("/lancamento/");
		mockMvc.perform(
				MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+token)
				).andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()));
	}

}
