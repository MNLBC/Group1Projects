package homework1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	@Id
	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_score")
	private Integer studentScore;

	@JoinColumn(name = "student_teacherid", referencedColumnName = "teacher_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Teacher teacherId;

	public Student() {
	}

	public Student(Integer studentId) {
		this.studentId = studentId;
	}

	public Student(Integer studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public Student(Integer studentId, String studentName, Integer studentScore) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
	}

	public Student(Integer studentId, String studentName, Integer studentScore, Teacher teacherId) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentScore = studentScore;
		this.teacherId = teacherId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(Integer studentScore) {
		this.studentScore = studentScore;
	}

	public Teacher getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Teacher teacherId) {
		this.teacherId = teacherId;
	}

}
