package com.dpr.examiner.model;

import java.util.List;


import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author dharmesh
 *
 */
@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int facultyId;
	private String facultyName;
	private long phoneNumber;
	private String email;
	private String userName;
	private String password;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
	private List<Exam> exams;

	public Faculty() {
		super();
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Faculty(int facultyId, String facultyName, long phoneNumber, String email, String userName, String password,
			Subject subject, List<Exam> exams) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.subject = subject;
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", userName=" + userName + ", password=" + password + ", subject=" + subject
				+ ", exams=" + exams + "]";
	}

	
	
}
