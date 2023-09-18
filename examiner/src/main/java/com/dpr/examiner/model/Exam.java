package com.dpr.examiner.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exam {

	@Id
	private int examId;
	private String examName;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "exam_student", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> assignedStudents;

	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

	@JsonIgnore
	@OneToOne(mappedBy = "exam", fetch = FetchType.LAZY)
	private Result result;

	public Exam() {
		super();
	}

	public Exam(int examId, String examName, LocalDateTime startTime, LocalDateTime endTime,
			List<Student> assignedStudents, Faculty faculty, Result result) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.assignedStudents = assignedStudents;
		this.faculty = faculty;
		this.result = result;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public List<Student> getAssignedStudents() {
		return assignedStudents;
	}

	public void setAssignedStudents(List<Student> assignedStudents) {
		this.assignedStudents = assignedStudents;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", assignedStudents=" + assignedStudents + ", faculty=" + faculty + ", result=" + result + "]";
	}

	
}
