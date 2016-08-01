package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.model.Teacher;

public class TeacherService {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}

	public String createTeacher(EntityManager em, Teacher teacher) {
		em.getTransaction().begin();
		em.persist(teacher);
		em.getTransaction().commit();
		return teacher.getTeacherId();
	}

	public Teacher getTeacher(EntityManager em, String id) {
		Teacher teacher = em.find(Teacher.class, id);
		return teacher;
	}

	public Teacher updateTeacher(EntityManager em, Teacher teacher) {
		em.getTransaction().begin();
		em.merge(teacher);
		em.getTransaction().commit();
		return teacher;
	}

	public void removeTeacher(EntityManager em, Teacher teacher) {
		em.getTransaction().begin();
		em.remove(teacher);
		em.getTransaction().commit();
	}

	public List<Teacher> getTeacherList() {
		return entityManager.createQuery("SELECT t FROM Teacher t").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
