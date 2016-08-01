package edu.javacourse.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.User;

public class UserService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
        System.out.println(entityManagerFactory.getClass().getSimpleName());
        entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getClass().getSimpleName());

    }

    public  User getUser(EntityManager em, Integer id) {
    	User user = em.find(User.class, id);
        return user;
    }
    

    
    public  int createUser(EntityManager em, User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user.getUserId();
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }
}
