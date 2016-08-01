package com.oocl.mnlbc.jpa.entity;

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
@Table(name = "TEACHER")
public class Teacher implements Serializable {

	@Id

	@Column(name = "teacher_id")
	private String teacher_id;
	@Column(name = "teacher_name")
	private String teacher_name;
	@Column(name = "teacher_school_name")
	private String teacher_school_name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentTeacherId", fetch = FetchType.LAZY)
	private List<Student> studentList;

	public Teacher() {

	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_school_name() {
		return teacher_school_name;
	}

	public void setTeacher_school_name(String teacher_school_name) {
		this.teacher_school_name = teacher_school_name;
	}

	public Teacher(String teacher_id, String teacher_name, String teacher_school_name) {
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_school_name = teacher_school_name;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacher_id == null && other.teacher_id != null) || (this.teacher_id != null && !this.teacher_id.equals(other.teacher_id))) {
            return false;
        }
        return true;
    }
	@Override
	public String toString() {
		return "Teacher{" + "teacher_id=" + teacher_id + ", teacher_name='" + teacher_name + ", teacher_school_name='"
				+ teacher_school_name + '\'' + '}';
	}

}
