package br.com.thundercoders.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.thundercoders.model.Lancamento;
import org.springframework.data.repository.query.Param;

public interface LancamentoRepository extends CrudRepository<Lancamento, Integer> {

	@Query("FROM Lancamento l WHERE l.conta.id = :id")
	public List<Lancamento> findAllByContaId(@Param("id") Integer id);

	public List<Lancamento> findAllByContaIdAndDataHoraBetween(@Param("idConta")Integer idConta,@Param("dataInicial") LocalDateTime dataInicial,
															   @Param("dataFinal") LocalDateTime dataFinal);

}
