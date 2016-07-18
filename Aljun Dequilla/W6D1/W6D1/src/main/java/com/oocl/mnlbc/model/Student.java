package com.oocl.mnlbc.model;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STUDENT_ID")
	private String studentId;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@Column(name = "STUDENT_SCORE")
	private int studentScore;

	@JoinColumn(name = "STUDENT_TEACHERID", referencedColumnName = "TEACHER_ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teacher teacher;

	public Student() {
	}

	public Student(String studentId) {
		this.studentId = studentId;
	}

	public Student(String studentId, String studentName, int studentScore) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (studentId != null ? studentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Student)) {
			return false;
		}
		Student other = (Student) object;
		if ((this.studentId == null && other.studentId != null)
				|| (this.studentId != null && !this.studentId.equals(other.studentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.oocl.mnlbc.model.Student[ studentId= '" + studentId + "', studentName= '" + studentName + "', studentScore= " + studentScore + " ]";
	}
}
