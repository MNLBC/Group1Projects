package homework1.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import homework1.entity.Teacher;

public class TeacherService {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public void init(){
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
    public  int createTeacher(EntityManager em, Teacher teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        return teacher.getTeacherId();
    }
	
	
}
