package com.oocl.mnlbc.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.dao.IGenericDAO;

public class GenericDAOImpl<ModelT> implements IGenericDAO<ModelT> {
	private transient final Class<ModelT> entityClass;

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
	EntityManager entitymanager = emfactory.createEntityManager();

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		try {
			entityClass = (Class<ModelT>) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<ModelT> getAll() {
		List<ModelT> results = (List<ModelT>) entitymanager
				.createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass).getResultList();
		return results;
	}

}
