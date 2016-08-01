package com.oocl.mnlbc.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Teacher;

public class TeacherService {
	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        entityManager = entityManagerFactory.createEntityManager();

    }


    public  Teacher getTeacher(EntityManager em, Integer id) {
        Teacher teacher = em.find(Teacher.class, id);
        return teacher;
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
