package com.dpr.examiner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dpr.examiner.dao.ExamDao;
import com.dpr.examiner.dao.StudentDao;
import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Result;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.repository.StudentRepository;

@Service
public class StudentServiceImpl {

	private StudentDao studentDao;
	private ExamDao examDao;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentDao studentDao, ExamDao examDao) {
		this.studentDao = studentDao;
		this.examDao = examDao;
	}

	public String saveStudent(Student student) {

		studentDao.insertStudent(student);
		return "user savved";
	}

	public List<Student> getStudents() {

		return studentDao.getStudents();
	}

	public Student getStudentById(int userId) {

		return studentDao.getStudentById(userId);
	}

	public List<Student> getStudentByName(String name) {
		return studentDao.getStudentByName(name);

	}

	public String updateStudent(Student student) {
		studentDao.updateStudent(student);

		return "updated";

	}

	public String deleteStudent(int studentId) {
		studentDao.deleteStudent(studentId);

		return "studnt " + studentId + " removed";
	}

	public List<Student> getAllStudentsSortedByIdAsc() {
		return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "studentId"));
	}

	public List<Student> getAllStudentsSortedByIdDesc() {
		return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "studentId"));
	}

	public List<Student> getAllStudentsSortedByNameDesc() {
		return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "studentName"));
	}

	public List<Student> getAllStudentsSortedByNameAsc() {
		return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "studentName"));
	}

	public String enrollStudentInExam(int studentId, int examId) {
		Student student = getStudentById(studentId);
		Exam exam = examDao.getExamById(examId);

		if (student == null || exam == null) {
			return "Student or exam not found.";
		} else {

		}

		return "Student enrolled in the exam successfully.";
	}

	public Student updatePhoneNumber(int studentId, Student student) {

		String phoneNumber = student.getPhoneNumber();
		return studentDao.updatePhoneNumber(studentId, phoneNumber);
	}

	public Student updateEmail(int studentId, Student student) {
		String newEmail = student.getStudentEmail();
		return studentDao.updateEmail(studentId, newEmail);
	}

	public Student updateName(int studentId, Student student) {
		// TODO Auto-generated method stub
		String newName = student.getStudentName();
		return studentDao.updateStudentName(studentId, newName);

	}

	public String changePassword(int studentId, String phoneNumber, Student student) {
		if (phoneNumber == student.getPhoneNumber()) {
			String newPassword = student.getPassword();
			return studentDao.updatePasswordbyPhone(studentId, newPassword);

		} else {
			return "phone number not matched";
		}

	}

	public String changePasswordByEmail(int studentId, String email, Student student) {
		if (email == student.getStudentEmail()) {
			String newPassword = student.getPassword();
			return studentDao.updatePasswordByEmail(studentId, newPassword);

		} else {
			return "email not matched";
		}
	}

	public List<Exam> getExamsForStudent(int studentId) {
		return studentDao.getExamsForStudent(studentId);
	}

	public String leaveExam(int studentId, int examId) {
		return studentDao.removeStudentFromExam(studentId, examId);
	}

	public List<Result> getResultsByStudentId(int studentId) {
		return studentDao.getResultsByStudentId(studentId);
	}

	public Student getStudentByUserName(String userName) {
		return studentDao.getStudentByUsername(userName);
	}

	public Student getStudentByEmail(String email) {
		return studentDao.getStudentByEmail(email);
	}

}
