package br.com.thundercoders.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.thundercoders.model.Usuario;

public class DtoUsuario {

	@NotNull
	@NotEmpty
	@Size(max = 50)
	private String login;

	@NotEmpty
	@NotNull
	private String senha;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String cpf;

	@Min(10)
	private Double saldo;
	
	private String telefone;

	public DtoUsuario(String login, String senha, String nome, String cpf, Double saldo,String telefone) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldo;
		this.telefone = telefone;
	}

	public DtoUsuario(Usuario usuario) {
		this.login = usuario.getUsername();
		this.senha = usuario.getPassword();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.telefone = usuario.getTelefone();
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

	public Double getSaldo() {
		return saldo;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public Usuario converte() {

		return new Usuario(login, senha, nome, cpf,telefone);
	}

	@Override
	public String toString() {
		return "DtoUsuario [login=" + login + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf + ", saldo="
				+ saldo + ", telefone=" + telefone + "]";
	}
	

}
