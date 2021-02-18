package br.com.thundercoders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.thundercoders.model.PlanoConta;
import br.com.thundercoders.model.PlanoContaTipo;
import br.com.thundercoders.model.dto.DtoPlanoContaResponse;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer> {

	@Query("Select new br.com.thundercoders.model.dto.DtoPlanoContaResponse(id, descricao, tipo) from PlanoConta p where p.tipo= :tipo")
	List<DtoPlanoContaResponse> findAllByTipo(PlanoContaTipo tipo);
	
	@Query("Select new br.com.thundercoders.model.dto.DtoPlanoContaResponse(id, descricao, tipo) from PlanoConta p")
	List<DtoPlanoContaResponse> findAllPlanoConta();
}
