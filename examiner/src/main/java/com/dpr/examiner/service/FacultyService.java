package com.dpr.examiner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpr.examiner.dao.FacultyDao;
import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Faculty;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.model.Subject;

@Service
public class FacultyService {

	@Autowired
	FacultyDao facultyDao;

	public List<Faculty> getfacultyies() {
		return facultyDao.getFaculties();
	}

	public Faculty getFacultyById(int facultyId) {

		return facultyDao.getFacultyById(facultyId);
	}

	public String saveFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		return facultyDao.insertFaculty(faculty);
	}

	public String updateFaculty(Faculty faculty) {
		return facultyDao.updateFaculty(faculty);
	}

	public String deleteFaculty(int facultyId) {
		facultyDao.deleteFaculty(facultyId);

		return "studnt " + facultyId + " removed";
	}

	public String assignSubject(int facultyId, int subjectId) {

		return facultyDao.assignSubject(facultyId, subjectId);
	}

	public Subject getSubject(int facultyId) {
		// TODO Auto-generated method stub
		return facultyDao.getSubject(facultyId);
	}

	public Faculty updatePhoneNumber(int facultyId, Faculty faculty) {

		long phoneNumber = faculty.getPhoneNumber();
		return facultyDao.updatePhoneNumber(facultyId, phoneNumber);
	}

	public Faculty updateEmail(int facultyId, Faculty faculty) {
		String newEmail = faculty.getEmail();
		return facultyDao.updateEmail(facultyId, newEmail);
	}

	public Faculty updateName(int facultyId, Faculty faculty) {
		// TODO Auto-generated method stub
		String newName = faculty.getFacultyName();
		return facultyDao.updateStudentName(facultyId, newName);

	}

	public String changePassword(int facultyId, String phoneNumber, Faculty faculty) {
		if (Long.parseLong(phoneNumber) == faculty.getPhoneNumber()) {
			String newPassword = faculty.getPassword();
			return facultyDao.updatePasswordbyPhone(facultyId, newPassword);

		} else {
			return "phone number not matched";
		}

	}

	public String changePasswordByEmail(int facultyId, String email, Faculty faculty) {
		if (email == faculty.getEmail()) {
			String newPassword = faculty.getPassword();
			return facultyDao.updatePasswordByEmail(facultyId, newPassword);

		} else {
			return "email not matched";
		}
	}

	public List<Exam> getExamsForFaculty(int facultyId) {
		return facultyDao.getExamsForFaculty(facultyId);
	}

	public String assignFacultyToExam(int examId, int facultyId) {
		return facultyDao.assignFacultyToExam(examId, facultyId);
	}

	public String removeFacultyFromExam(int examId, int facultyId) {
		return facultyDao.removeFacultyFromExam(examId, facultyId);
	}

	public Faculty getFacultytByUserName(String userName) {
		return facultyDao.getFacultyByUsername(userName);
	}

	public Faculty getFacultytByEmail(String email) {
		return facultyDao.getFacultyByEmail(email);
	}

	public String changeUsername(int facultyId, String phoneNo, Faculty faculty) {
		if (Long.parseLong(phoneNo) == faculty.getPhoneNumber()) {
			String newUsername = faculty.getUserName();
			return facultyDao.updateUsernamebyPhone(facultyId, newUsername);

		} else {
			return "phone number not matched";
		}
	}
	
	

	public String changeUsernameByEmail(int facultyId, String email, Faculty faculty) {
		if (email == faculty.getEmail()) {
			String newUsername = faculty.getUserName();
			return facultyDao.updateUsernameByEmail(facultyId, newUsername);

		} else {
			return "email not matched";
		}
	}


}
