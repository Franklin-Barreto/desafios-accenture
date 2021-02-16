package br.com.thundercoders.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.dto.DtoContaDashBoard;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

	@Query("SELECT new br.com.thundercoders.model.dto.DtoContaDashBoard(saldo,limite) FROM Conta c  WHERE c.usuario.id = :id GROUP BY c.usuario.id")
	Optional<DtoContaDashBoard> findDashBoardUsuarioId(Integer id);

	List<Conta> findByUsuarioId(Integer id);

	ContaCorrente findByNumero(String numero);

}
