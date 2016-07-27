package com.oocl.mnlbc.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractJPADAO<T extends Serializable> {

	private Class<T> clazz;

	protected EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
	protected EntityManager entityManager = emfactory.createEntityManager();

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
		entityManager.getTransaction().begin();
		entityManager.remove( entity );
		entityManager.getTransaction().commit();
	}


	public void deleteById(int id) {
		T entity = find(id);
		entityManager.getTransaction().begin();
		entityManager.remove( entity );
		entityManager.getTransaction().commit();
	}

}
