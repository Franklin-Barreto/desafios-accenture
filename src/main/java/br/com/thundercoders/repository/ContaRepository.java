package br.com.thundercoders.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.thundercoders.model.Conta;
import br.com.thundercoders.model.ContaCorrente;
import br.com.thundercoders.model.dto.DtoContaDashBoard;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

	@Query("SELECT new br.com.thundercoders.model.dto.DtoContaDashBoard(saldo,limite) FROM Conta c  WHERE c.usuario.id = :id GROUP BY c.usuario.id")
	DtoContaDashBoard findDashBoardUsuarioId(Integer id);

	Conta findByUsuarioId(Integer id);

	ContaCorrente findByNumero(String numero);

}
