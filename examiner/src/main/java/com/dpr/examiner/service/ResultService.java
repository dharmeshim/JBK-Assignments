package com.dpr.examiner.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpr.examiner.dao.ResultDao;
import com.dpr.examiner.model.Result;

@Service
public class ResultService {

	private final ResultDao resultDao;
	private final int passScore = 40;

	@Autowired
	public ResultService(ResultDao resultDao) {
		this.resultDao = resultDao;
	}

	public List<Result> getAllResults() {
		return resultDao.getAllResults();
	}

	public Result createResult(Result result) {

		return null;
	}

	public String deleteResult(Long resultId) {

		return resultDao.deleteResult(resultId);

	}

	public Result getResultById(Long resultId) {
		return resultDao.getResultById(resultId);
	}

	public Result updateResult(Long resultId, Result updatedResult) {
		return resultDao.updateResult(resultId, updatedResult);
	}

	public List<Result> getResultsByStudentId(int studentId) {
		return resultDao.getResultsByStudentId(studentId);
	}

	public List<Result> getResultsByExamId(int examId) {
		return resultDao.getResultsByExamId(examId);
	}

	public List<Result> getPassedStudents() {
		List<Result> allResults = resultDao.getAllResults();
		List<Result> passedStudents = new ArrayList<>();

		for (Result result : allResults) {
			if (result.getScore() >= passScore) {
				passedStudents.add(result);
			}
		}
		return passedStudents;
	}

	public List<Result> getFailedStudents() {
		List<Result> allResults = resultDao.getAllResults();
		List<Result> failedStudents = new ArrayList<>();

		for (Result result : allResults) {
			if (result.getScore() < passScore) {
				failedStudents.add(result);
			}
		}
		return failedStudents;
	}

	public List<Result> getStudentsAboveScore(double mark) {
		List<Result> allResults = resultDao.getAllResults();
		List<Result> studentsAboveScore = new ArrayList<>();

		for (Result result : allResults) {
			if (result.getScore() > mark) {
				studentsAboveScore.add(result);
			}
		}
		return studentsAboveScore;
	}

	public List<Result> getTopScorers(int count) {
		List<Result> allResults = resultDao.getAllResults();
		allResults.sort(Comparator.comparing(Result::getScore).reversed());
		return allResults.stream().limit(count).collect(Collectors.toList());
	}
	
	public List<Result> getPerfectScorers() {
	    List<Result> allResults = resultDao.getAllResults();
	    List<Result> perfectScorers = new ArrayList<>();

	    for (Result result : allResults) {
	        if (result.getScore() == 100) {
	            perfectScorers.add(result);
	        }
	    }
	    return perfectScorers;
	}

	public List<Result> getResultsByStudentName(String studentName) {
		return resultDao.getResultsByStudentName(studentName);
	}

	public List<Result> getResultsByStudentPhone(String phoneNumber) {
		return resultDao.getResultsByStudentPhone(phoneNumber);
	}

	public List<Result> getResultsByStudentEmail(String email) {
		return resultDao.getResultsByStudentEmail(email);
	}

	public List<Result> getResultsByExamName(String examName) {
		return resultDao.getResultsByExamName(examName);
	}

	public List<Result> getResultsBySubject(int subjectId) {
		return resultDao.getResultsBySubject(subjectId);
	}

	public List<Result> getResultsByFaculty(int facultyId) {
		return resultDao.getResultsByFaculty(facultyId);
	}

	public List<Result> getResultsAboveMarks(double minMarks) {
		return resultDao.getResultsAboveMarks(minMarks);
	}

	public List<Result> getResultsBelowMarks(double maxMarks) {
		return resultDao.getResultsBelowMarks(maxMarks);
	}

	

}
