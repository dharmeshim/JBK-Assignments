package com.dpr.examiner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpr.examiner.dao.SubjectDao;
import com.dpr.examiner.model.Subject;

@Service
public class SubjectServiceImpl {

	private SubjectDao subjectDao;

	@Autowired
	public SubjectServiceImpl(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public Subject createSubject(Subject subject) {
		return subjectDao.createSubject(subject);
	}

	public List<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

	public Subject getSubjectById(int subjectId) {
		return subjectDao.getSubjectById(subjectId);
	}

	public Subject updateSubject(int subjectId, Subject updatedSubject) {
		return subjectDao.updateSubject(subjectId, updatedSubject);
	}

	public String deleteSubject(int subjectId) {
		return subjectDao.deleteSubject(subjectId);
	}

	public List<Subject> getAllSubjectsById() {
		return subjectDao.getallSubjectsById();
	}

	public List<Subject> getAllSubjectByIdDesc() {
		return subjectDao.getSubjectByIdDEsc();
	}

	public List<Subject> searchSubjectsByName(String keyword) {
		return subjectDao.searchSubjectsByName(keyword);
	}

	public List<Subject> getSubjectsByCredits(int credits) {

		return subjectDao.getSubjectsByCredits(credits);
	}

	public List<Subject> getSubjectAboveCredits(double minCredit) {

		return subjectDao.getSubjectAboveCredits(minCredit);
	}

	public List<Subject> getSubjectBelowCredits(double maxCredit) {

		return subjectDao.getSubjectBelowCredits(maxCredit);
	}

}
