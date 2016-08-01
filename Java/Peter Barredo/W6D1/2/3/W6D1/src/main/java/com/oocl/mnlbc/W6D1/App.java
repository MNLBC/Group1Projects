package com.oocl.mnlbc.W6D1;

import javax.persistence.EntityManager;

import com.oocl.mnlbc.entity.Teacher;
import com.oocl.mnlbc.service.TeacherService;


public class App 
{
    public static void main( String[] args )
    {
    	
    	TeacherService ts = new TeacherService();
        ts.init();
        EntityManager em = ts.getEntityManager();
        
        Teacher teacher = ts.getTeacher(em, 1);
        System.out.println("Teacher Name: " + teacher.getTeacherName());
        System.out.println("Teacher School Name: " + teacher.getTeacherSchoolName());
        System.out.println("Average Score of the Student " + teacher.getStudentAverage());
    }
}
