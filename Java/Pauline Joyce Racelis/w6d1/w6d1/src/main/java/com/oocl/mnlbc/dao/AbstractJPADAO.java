package com.oocl.mnlbc.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractJPADAO<GenericEntity> implements GenericDAO<GenericEntity>{
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());;
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	private transient final Class<GenericEntity> entityClass;
	@SuppressWarnings("unchecked")
	public AbstractJPADAO() {
		entityClass = (Class<GenericEntity>) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<GenericEntity> getAll() {
		List<GenericEntity> results = entityManager.
				createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass).getResultList();
		return results;
	}

	public GenericEntity persist(GenericEntity entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(entity);
		getEntityManager().flush();
		getEntityManager().getTransaction().commit();
		return entity;
	}

	private EntityManager getEntityManager() {
		return entityManager;
	}

	public void delete(GenericEntity entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().flush();
		getEntityManager().getTransaction().commit();
		
	}

}
