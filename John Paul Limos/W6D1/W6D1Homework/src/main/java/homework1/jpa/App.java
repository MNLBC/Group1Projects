package homework1.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import homework1.entity.Teacher;
import homework1.service.TeacherService;


public class App {
	public static void main(String[] args){
		TeacherService ts = new TeacherService();
		ts.init();
		EntityManager em = ts.getEntityManager();
		//Creating Teacher
//		System.out.println("============================");
//		System.out.println("Creating Teacher");
//		Teacher teacherToBeCreated = new Teacher(2,"TaylorSwift", "Asia Pacific College");
//		ts.createTeacher(em, teacherToBeCreated);
//		System.out.println("Created teacher successfully");
//		System.out.println("============================");
		
		getTeachersAndStudents(em);
	}
	private static void getTeachersAndStudents(EntityManager em) {
		List<Teacher> result = em.createQuery("select t from Teacher t").getResultList();
		System.out.println("============================");
		System.out.println("Showing teachers and student average score");
		int averageScore = 0;
		for(Teacher t : result){
			System.out.println(t.getTeacherId() + "\t\t" +t.getTeacherName()+ "\t\t" + t.getTeacherSchoolName() + "\t\t" + t.getStudentAverage());
		}
	}
}
