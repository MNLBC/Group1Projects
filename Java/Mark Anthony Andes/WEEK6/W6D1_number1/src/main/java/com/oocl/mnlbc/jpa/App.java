package com.oocl.mnlbc.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Student;
import com.oocl.mnlbc.entity.Teacher;
import com.oocl.mnlbc.service.TeacherService;

public class App {
	
	public static void main(String[] args) {
		 TeacherService rs = new TeacherService();
	        rs.init();
	        EntityManager em = rs.getEntityManager();
	       
	        Teacher t = rs.getTeacher(em, "1");
	        System.out.println(t.toString());
	        List<Student> s = t.getStudentList();
	        double avg = 0;
	        for (Student student : s) {
	        	avg += (student.getStudentScore()/s.size()) ;
	       
	        }
	        System.out.println("Average score of Studets: "+avg); 
	}

}
