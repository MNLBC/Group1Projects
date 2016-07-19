/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.model.Item;

/**
 * @author DEQUIAL
 *
 */
public class ItemService {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	/**
	 * 
	 */
	public ItemService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());
	}

	public String createItem(EntityManager em, Item item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		return item.getItemId();
	}

	public Item getItem(EntityManager em, String id) {
		Item item = em.find(Item.class, id);
		return item;
	}

	public Item updateItem(EntityManager em, Item item) {
		em.getTransaction().begin();
		em.merge(item);
		em.getTransaction().commit();
		return item;
	}

	public void removeItem(EntityManager em, Item item) {
		em.getTransaction().begin();
		em.remove(item);
		em.getTransaction().commit();
	}

	public List<Item> getItemList() {
		return entityManager.createQuery("SELECT t FROM Item t").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
