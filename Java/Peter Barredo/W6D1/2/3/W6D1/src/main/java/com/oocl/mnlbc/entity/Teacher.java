package com.oocl.mnlbc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

	@Id
	@Column(name = "teacher_id")
	private Integer teacherId;

	@Column(name = "teacher_name")
	private String teacherName;

	@Column(name = "teacher_school_name")
	private String teacherSchoolName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId", fetch = FetchType.LAZY)
	private List<Student> students;


	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSchoolName() {
		return teacherSchoolName;
	}

	public void setTeacherSchoolName(String teacherSchoolName) {
		this.teacherSchoolName = teacherSchoolName;
	}

	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Integer getStudentAverage() {
		int average = 0, sum = 0;
		
		for (Student s : students) {
			sum += s.getStudentScore();
		}
		
		average = sum / students.size();
		return average;
	}
}
