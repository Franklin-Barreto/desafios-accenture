package br.com.thundercoders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.Usuario;
import br.com.thundercoders.model.dto.DtoUsuario;
import br.com.thundercoders.repository.UsuarioRepository;
import br.com.thundercoders.utils.TextoUtils;

@Service
public class UsuarioService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;
	private ContaService contaService;
	private BCryptPasswordEncoder pEnconder;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, ContaService contaService, BCryptPasswordEncoder pEnconder) {

		this.usuarioRepository = usuarioRepository;
		this.contaService = contaService;
		this.pEnconder = pEnconder;
	}

	public boolean loginComprimento(String login) {
		return login.length() <= 20;
	}

	public void incluir(Usuario usuarioEntity) throws IllegalAccessException {

		boolean comprimentoValido = TextoUtils.validaComprimento(usuarioEntity.getUsername(), 20);
		if (!comprimentoValido) {

			throw new IllegalAccessException("Comprimento inválido");
		}

		Usuario usuarioExists = usuarioRepository.findByLogin(usuarioEntity.getUsername());

		if (usuarioExists != null) 
		{
			throw new IllegalStateException("Já existe um usuario com o login " + usuarioEntity.getUsername());
		}

		usuarioRepository.save(usuarioEntity);
	}

	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário inexistente"));
	}

	public Usuario save(DtoUsuario dtoUsuario) {

		Usuario usuario = dtoUsuario.converte();

		usuario.setSenha( this.pEnconder.encode( usuario.getPassword() ));

		Usuario usuarioSalvo = this.usuarioRepository.save(usuario);
		Conta conta = dtoUsuario.getContaTipo().getConta();
		conta.setUsuario(usuario);
		conta.setSaldo(dtoUsuario.getSaldo());
		contaService.save(conta);
		return usuarioSalvo;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(username);
	}

	public Conta findContaUsuario(Integer id) {
		return this.contaService.findContaByUsuarioId(id);
	}

}
