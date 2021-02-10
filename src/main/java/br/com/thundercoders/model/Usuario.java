package br.com.thundercoders.model;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario extends EntidadeBase implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 20)
	private String login;

	@Column(length = 100, nullable = false)
	private String senha;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 12, nullable = false)
	private String cpf;

	public Usuario() {
	}

	public Usuario(String login, String senha, String nome, String cpf) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Usuario that = (Usuario) o;
		return Objects.equals(login, that.login) && Objects.equals(senha, that.senha) && Objects.equals(nome, that.nome)
				&& Objects.equals(cpf, that.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, senha, nome, cpf);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
