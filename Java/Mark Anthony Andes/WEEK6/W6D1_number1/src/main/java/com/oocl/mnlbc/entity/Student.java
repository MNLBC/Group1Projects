package com.oocl.mnlbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblStudent")
public class Student {
	
	@Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private String studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_score")
	private Integer studentScore;
	@JoinColumn(name = "student_teacherid", referencedColumnName = "teacher_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teacher studentTeacherId;

	public Student() {
	}

	public Student(String studentId) {
		this.studentId = studentId;
	}

	public Student(String studentId, String studentName, Integer studentScore) {
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

	public Integer getStudentScore() {
		return studentScore;
	}

	public Teacher getStudentTeacherId() {
		return studentTeacherId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentScore(Integer studentScore) {
		this.studentScore = studentScore;
	}

	public void setStudentTeacherId(Teacher studentTeacherId) {
		this.studentTeacherId = studentTeacherId;
	}
	
	
	 @Override
	    public String toString() {
	        return "edu.javacourse.jpa.entity.City[ studentId=" + studentId + " ]";
	    }
	
	
	

}
