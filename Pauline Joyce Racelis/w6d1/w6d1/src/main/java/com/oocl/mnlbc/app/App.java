package com.oocl.mnlbc.app;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.jpa.entity.Student;
import com.oocl.mnlbc.jpa.entity.Teacher;
import com.oocl.mnlbc.service.TeacherService;

public class App {

	public static void main(String[] args) {
		TeacherService rs = new TeacherService();
		rs.init();
		EntityManager em = rs.getEntityManager();
		Teacher teacher = rs.getTeacher(em, "3");

		System.out.println(teacher.toString());
		List<Student> s = teacher.getStudentList();
		double avg = 0;
		for (Student student : s) {
			avg += (student.getStudent_score() / s.size());

		}
		System.out.println("The average score of the students:  " + avg);
	}
}
