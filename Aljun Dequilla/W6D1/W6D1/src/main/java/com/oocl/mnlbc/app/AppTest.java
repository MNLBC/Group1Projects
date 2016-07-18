package com.oocl.mnlbc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.model.Student;
import com.oocl.mnlbc.model.Teacher;
import com.oocl.mnlbc.service.TeacherService;

public class AppTest {
	static TeacherService ts = new TeacherService();

	public static void main(String[] args) {
		ts.init();
		for (Teacher teacher : ts.getTeacherList()) {
			displayTeacherInfo(teacher.getTeacherId());
		}

	}

	private static void displayTeacherInfo(String id) {
		System.out.println("=============================");
		EntityManager em = ts.getEntityManager();
		Teacher teacher = ts.getTeacher(em, id);
		teacher.getStudents();
		if (!teacher.getStudents().isEmpty()) {
			String output = "Teacher: " + teacher.getTeacherName() + " \nSchool: " + teacher.getTeacherSchoolName()
					+ " \nStudents' Average Score: " + teacher.getStudentAverage();
			System.out.println(output);
		} else {
			System.out.println("No teacher exist!");
		}
		System.out.println("=============================");
	}

	private static void insertToDB(Teacher teacher) {
		EntityManager em = ts.getEntityManager();
		String id = ts.createTeacher(em, teacher);

		Student student = null;
		List<Student> students = new ArrayList<Student>();
		Random rand = new Random();

		em.getTransaction().begin();
		for (int i = 0; i < 10; i++) {

			student = new Student();
			student.setStudentId("S" + i);
			student.setStudentName("Student " + id);
			student.setStudentScore(rand.nextInt(100 - 50) + 50);
			student.setTeacher(teacher);
			students.add(student);
			em.persist(student);

		}
		teacher.setStudents(students);
		em.getTransaction().commit();
		em.close();
	}
}