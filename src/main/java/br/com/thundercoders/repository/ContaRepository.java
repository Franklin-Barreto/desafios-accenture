package br.com.thundercoders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
	
	List<Conta> findByUsuarioId(Integer id);

	ContaCorrente findByNumero(String numero);

}
