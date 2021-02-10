package br.com.thundercoders.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class RepositoryImpl<T extends Serializable> implements RepositoryI<T> {

	protected EntityManager em;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public RepositoryImpl(EntityManager em) {
		this.em = em;
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];

	}

	@Override
	public T save(T entity) {
		em.getTransaction().begin();
		T entitySaved = em.merge(entity);
		em.getTransaction().commit();
		return entitySaved;
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public List<T> findAll() {
		return em.createQuery("from " + entityClass.getName() + " t", entityClass).getResultList();
	}

	@Override
	public T findById(Integer id) {
		return em.find(entityClass, id);
	}

}
