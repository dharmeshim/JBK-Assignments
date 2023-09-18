package com.dpr.examiner.service;

import java.util.List;


import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpr.examiner.dao.ExamDao;
import com.dpr.examiner.dao.StudentDao;
import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Faculty;
import com.dpr.examiner.model.Result;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.repository.ExamRepository;


@Service
public class ExamServiceImpl {

	private final ExamRepository examRepository;
	private final StudentDao studentDao;
	private final ExamDao examDao;

	@Autowired
	public ExamServiceImpl(ExamRepository examRepository, ExamDao examDao, StudentDao studentDao) {
		this.examRepository = examRepository;
		this.studentDao = studentDao;
		this.examDao = examDao;
	}


	public Exam createExam(Exam exam) {
		return examRepository.save(exam);
	}

	public List<Exam> getAllExams() {
		// TODO Auto-generated method stub
		return examDao.getExams();
//		return examRepository.findAll();

	}

	public List<Exam> getExamByName(String examName) {
		return examDao.getExamByName(examName);
	}

	public Exam getExamById(int examId) {
		// TODO Auto-generated method stub
		return examDao.getExamById(examId);
	}

	public String deleteExam(int examId) {
		return examDao.deleteExam(examId);
	}


	public Exam updateExam(Exam exam) {
		return examDao.updateExam(exam);
	}


	public String assignStudentsToExam(int examId, List<Integer> studentIds) {
		return examDao.assignStudentsToExam(examId, studentIds);
	}


	public String removeStudentsFromExam(int examId, List<Integer> studentIds) {
		return examDao.removeStudentsFromExam(examId, studentIds);
	}


	public List<Student> getAssignedStudents(int examId) {
		return examDao.getAssignedStudents(examId);
	}


	public List<Exam> getAllExamsByTime() {
		return examDao.findAllSortedByTimeAsc();
	}
	
	public List<Exam> getAllExamsByTimeDesc() {
		return examDao.findAllSortedByTimeDesc();
	}


	public String addFacultyToExam(int examId, int facultyId) {
		return examDao.addFacultyToExam(examId, facultyId);
	}


	public String removeFacultyFromExam(int examId, int facultyId) {
		return examDao.removeFacultyFromExam(examId, facultyId);
	}


	public String changeFacultyForExam(int examId, int facultyId) {
		return examDao.changeFacultyForExam(examId, facultyId);
	}


	public List<Faculty> getAssignedFaculty(int examId) {
		return examDao.getAssignedFaculty(examId);
	}


	public List<Exam> getAllExamsById() {
		return examDao.findAllSortedByIdAsc();
	}


	public List<Exam> getAllExamsByIdDesc() {
		return examDao.findAllSortedByIdDesc();
	}


	public String assignStudentToExam(int examId, int studentId) {
		return examDao.assignStudentToExam(examId, studentId);
	}


	public String removeStudentFromExam(int examId, int studentId) {
		return examDao.removeStudentFromExam(examId, studentId);
	}


	public List<Result> getResultsByExamId(int examId) {
		return examDao.getResultsById(examId);
	}
}
