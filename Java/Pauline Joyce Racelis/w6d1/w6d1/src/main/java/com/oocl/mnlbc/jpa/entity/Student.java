package com.oocl.mnlbc.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	@Id

	@Column(name = "student_id")
	private String student_id;
	@Column(name = "student_name")
	private String student_name;
	@Column(name = "student_score")
	private Integer student_score;
	@JoinColumn(name = "student_teacherid", referencedColumnName = "teacher_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teacher studentTeacherId;

	public Student() {

	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public Student(String student_id, String student_name, Integer student_score, Teacher teacher_id) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_score = student_score;
		this.studentTeacherId = teacher_id;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public Integer getStudent_score() {
		return student_score;
	}

	public Student(String student_id, String student_name, Integer student_score) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_score = student_score;
	}

	public Teacher getTeacher_id() {
		return studentTeacherId;
	}

	public void setTeacher_id(Teacher teacher_id) {
		this.studentTeacherId = teacher_id;
	}

	public void setStudent_score(Integer student_score) {
		this.student_score = student_score;
	}

}
