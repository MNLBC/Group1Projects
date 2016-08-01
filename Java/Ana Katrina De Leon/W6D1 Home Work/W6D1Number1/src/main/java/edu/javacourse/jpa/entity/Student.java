package edu.javacourse.jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private String  studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_score")
    private Integer studentScore;
    
    @JoinColumn(name = "student_teacherid", referencedColumnName = "teacher_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Teacher teacherId;

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

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentScore(Integer studentScore) {
        this.studentScore = studentScore;
    }

    public Integer getStudentScore() {
        return studentScore;
    }
    
    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.javacourse.jpa.entity.Student[ studentId=" + studentId + " ]";
    }
}
