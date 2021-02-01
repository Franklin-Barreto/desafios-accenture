package br.com.thundercoders.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.thundercoders.model.Conta;

public interface ContaRepository extends CrudRepository<Conta,Integer>  {

	Conta findByUsuarioId(Integer id);

}
