package com.dpr.examiner.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long resultId;
    private double score;
    
    
  
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

	public Result() {
		super();
	}

	public Result(Long resultId, double score, Student student, Exam exam) {
		super();
		this.resultId = resultId;
		this.score = score;
		this.student = student;
		this.exam = exam;
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", score=" + score + ", student=" + student + ", exam=" + exam + "]";
	}

	
    

 
}
