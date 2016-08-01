package homework1.entity;

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
	private List<Student> studentList;

	public Teacher() {
	}

	public Teacher(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Teacher(Integer teacherId, String teacherName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	public Teacher(Integer teacherId, String teacherName, String teacherSchoolName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherSchoolName = teacherSchoolName;
	}

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

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Integer getStudentAverage() {
		int average = 0;
		int sum = 0;
		for (Student s : studentList) {
			sum += s.getStudentScore();
		}
		if(studentList.size() != 0)
			average = sum / studentList.size();
		return average;
	}
}
