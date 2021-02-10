package br.com.thundercoders.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.thundercoders.model.ContaTipo;
import br.com.thundercoders.model.Usuario;

public class DtoUsuario {

	@NotNull
	@NotEmpty
	@Size(max = 20)
	private String login;

	@NotEmpty
	@NotNull
	private String senha;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String cpf;

	private ContaTipo contaTipo;

	@Min(10)
	private Double saldo;

	public DtoUsuario(String login, String senha, String nome, String cpf, ContaTipo contaTipo, Double saldo) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.contaTipo = contaTipo;
		this.saldo = saldo;
	}

	public DtoUsuario(Usuario usuario) {
		this.login = usuario.getUsername();
		this.senha = usuario.getPassword();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public ContaTipo getContaTipo() {
		return contaTipo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Usuario converte() {

		return new Usuario(login, senha, nome, cpf);
	}

}
