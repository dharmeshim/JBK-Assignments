package com.dpr.examiner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpr.examiner.model.Subject;
import com.dpr.examiner.service.SubjectServiceImpl;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	private final SubjectServiceImpl subjectService;

	@Autowired
	public SubjectController(SubjectServiceImpl subjectService) {
		this.subjectService = subjectService;
	}


	@PostMapping("/create")
	public Subject createSubject(@RequestBody Subject subject) {
		return subjectService.createSubject(subject);
	}


	@GetMapping("/get-all-subjects")
	public List<Subject> getAllSubjects() {
		return subjectService.getAllSubjects();
	}


	@GetMapping("/get-subject-id/{subjectId}")
	public Subject getSubjectById(@PathVariable int subjectId) {
		return subjectService.getSubjectById(subjectId);
	}


	@PostMapping("/update-subject-id/{subjectId}")
	public Subject updateSubject(@PathVariable int subjectId, @RequestBody Subject updatedSubject) {
		return subjectService.updateSubject(subjectId, updatedSubject);
	}

	
	@PostMapping("delete-subject-id/{subjectId}")
	public String deleteSubject(@PathVariable int subjectId) {
		return subjectService.deleteSubject(subjectId);
	}
	
	@GetMapping("/get-all-subject-sorted-by-Id-asc")
	public List<Subject> getAllsubjectSortedByIdAsc() {
		return subjectService.getAllSubjectsById();
	}

	@GetMapping("/get-all-subject-sorted-by-Id-desc")
	public List<Subject> getAllsubjectSortedByIdDesc() {
		return subjectService.getAllSubjectByIdDesc();
	}
	
	@GetMapping("/search-subjects/{keyword}")
	public List<Subject> searchSubjectsByName(@PathVariable String keyword) {
	    return subjectService.searchSubjectsByName(keyword);
	}

	
	@GetMapping("/get-subjects-by-credits/{credits}")
	public List<Subject> getSubjectsByCredits(@PathVariable int credits) {
	    return subjectService.getSubjectsByCredits(credits);
	}

	@GetMapping("/get-above-credits/{minCredit}")
	public List<Subject> getSubjectAboveCredits(@PathVariable double minCredit){
		return subjectService.getSubjectAboveCredits(minCredit);
	}
	
	@GetMapping("/get-below-credits/{minCredit}")
	public List<Subject> getSubjectBelowCredits(@PathVariable double maxCredit){
		return subjectService.getSubjectBelowCredits(maxCredit);
	}
	
}
