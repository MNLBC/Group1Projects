package com.oocl.mnlbc.model;

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
@Table(name = "Teacher")
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TEACHER_ID")
	private String teacherId;

	@Column(name = "TEACHER_NAME")
	private String teacherName;

	@Column(name = "TEACHER_SCHOOL_NAME")
	private String teacherSchoolName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
	private List<Student> students;

	public Teacher() {
	}

	public Teacher(String teacherId) {
		this.teacherId = teacherId;
	}

	public Teacher(String teacherId, String teacherName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	public Teacher(String teacherId, String teacherName, String teacherSchoolName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherSchoolName = teacherSchoolName;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getTeacherSchoolName() {
		return teacherSchoolName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setTeacherSchoolName(String teacherSchoolName) {
		this.teacherSchoolName = teacherSchoolName;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getStudentAverage() {
		int sum = 0;
		for (Student student : students) {
			sum += student.getStudentScore();
		}
		return (sum / students.size());
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (teacherId != null ? teacherId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) object;
		if ((this.teacherId == null && other.teacherId != null)
				|| (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Teacher{teacherId= '" + teacherId + "', teacherName= '" + teacherName + "', teacherSchoolName= '"
				+ teacherSchoolName + "' }";
	}
}
