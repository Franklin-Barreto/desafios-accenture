package br.com.thundercoders.repository;

import java.io.Serializable;
import java.util.List;

public interface RepositoryI<T extends Serializable> {

	public T save(T entity);

	public void update(T entity);

	public List<T> findAll();

	public T findById(Integer id);
}
