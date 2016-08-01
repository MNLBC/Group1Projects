package edu.javacourse.jpa;

import edu.javacourse.jpa.entity.Student;
import edu.javacourse.jpa.entity.Teacher;
import edu.javacourse.jpa.service.TeacherService;

import javax.persistence.EntityManager;
import java.util.List;

public class SimpleExample {

	public static void main(String[] args) {
		TeacherService rs = new TeacherService();
		rs.init();
		EntityManager em = rs.getEntityManager();
		
		Teacher t = rs.getTeacher(em, "1");
		System.out.println("Teacher Name: " + t.getTeacherName());
		System.out.println("School Name: " + t.getTeacherSchoolName());
		System.out.println("Average Score of Students: " + computeAverage(t));
	}

	private static Integer computeAverage(Teacher t) {
		List<Student> s = t.getStudentList();
		int total = 0;
		for (Student student : s) {
			int studScore = student.getStudentScore();
					total += studScore;
		}
		int ave = total/s.size();
		
		return ave;
	}
}
