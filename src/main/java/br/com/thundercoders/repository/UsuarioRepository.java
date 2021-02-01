package br.com.thundercoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.thundercoders.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


	@Query("SELECT tu FROM Usuario tu WHERE tu.login = :login")
	public boolean exists(String login);
	
	
	public Usuario findByLogin(String login);

}
