package com.dpr.examiner.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String phoneNumber;
	private String age;
	private String role;
	private String password;
	private long registerNo;

	@JsonIgnore
	@ManyToMany(mappedBy = "assignedStudents")
	private List<Exam> exams;

	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private List<Result> results;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, String studentEmail, String phoneNumber, String age, String role,
			String password, long registerNo, List<Exam> exams, List<Result> results) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.role = role;
		this.password = password;
		this.registerNo = registerNo;
		this.exams = exams;
		this.results = results;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(long registerNo) {
		this.registerNo = registerNo;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", phoneNumber=" + phoneNumber + ", age=" + age + ", role=" + role + ", password=" + password
				+ ", registerNo=" + registerNo + ", exams=" + exams + ", results=" + results + "]";
	}

	
}
