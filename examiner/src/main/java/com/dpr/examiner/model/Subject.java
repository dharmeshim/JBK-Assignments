package com.dpr.examiner.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	private int subjectId;
	private String subjectName;
	private String subjectCode;
	private int creditPoints;

//	@JsonIgnore
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subject")
//	@JoinColumn(name = "faculty_id")
//	private Faculty faculty;
	
	@JsonIgnore
	 @OneToOne
	    @JoinColumn(name = "faculty_id")
	    private Faculty faculty;

	public Subject() {
		super();
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getCreditPoints() {
		return creditPoints;
	}

	public void setCreditPoints(int creditPoints) {
		this.creditPoints = creditPoints;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode
				+ ", creditPoints=" + creditPoints + ", faculty=" + faculty + "]";
	}

	public Subject(int subjectId, String subjectName, String subjectCode, int creditPoints, Faculty faculty) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.creditPoints = creditPoints;
		this.faculty = faculty;
	}

}
