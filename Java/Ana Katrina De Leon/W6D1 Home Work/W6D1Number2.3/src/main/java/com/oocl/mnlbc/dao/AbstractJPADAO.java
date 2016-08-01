package com.oocl.mnlbc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class AbstractJPADAO<T, PK extends Serializable> implements GenericDAO<T, PK> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	public AbstractJPADAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	public T read(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	public T update(T t) {
		return this.entityManager.merge(t);
	}

	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

}
