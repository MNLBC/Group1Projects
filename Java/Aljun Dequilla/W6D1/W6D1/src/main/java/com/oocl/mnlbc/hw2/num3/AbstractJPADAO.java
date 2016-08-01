/**
 * 
 */
package com.oocl.mnlbc.hw2.num3;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author DEQUIAL
 *
 */
public class AbstractJPADAO<T> implements GenericDAO<T> {

	private EntityManagerFactory emFactory;
	private EntityManager em;
	private Class<T> c;

	public AbstractJPADAO() {
		emFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(emFactory.getClass().getSimpleName());
		em = emFactory.createEntityManager();
		System.out.println(em.getClass().getSimpleName());
		c = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void create(T model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
	}

	public List<T> getList() {
		return (List<T>) em.createNamedQuery("from " + c.getName());
	}

	public void update(T model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
	}

	public void delete(T model) {
		em.getTransaction().begin();
		em.remove(model);
		em.getTransaction().commit();

	}

	public T getById(int id) {
		return em.find(c, id);
	}
}
