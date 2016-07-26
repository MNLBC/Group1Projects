package com.oocl.mnlbc.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJPADAO<T extends Serializable> {

	private Class<T> clazz;

	@PersistenceContext
	protected EntityManager entityManager;

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T find(int id) {
		return entityManager.find(clazz, id);
	}

	public List<T> getAll() {
		return (List<T>) entityManager.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz).getResultList();
	}

	public void add(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();

	}

	public T update(T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();

		return entity;
	}

	public void delete(T entity) {

	}


	public void deleteById(long entityId) {

	}

}
