package com.dpr.examiner.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Faculty;
import com.dpr.examiner.model.Subject;
import com.dpr.examiner.service.FacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	FacultyService facultyService;

	@PostMapping("/save")
	public String saveUser(@RequestBody Faculty faculty) {
		return facultyService.saveFaculty(faculty);

	}

	@GetMapping("/get-all-faculty")
	public List<Faculty> getAllFaculty() {
		return facultyService.getfacultyies();
	}

	@GetMapping("/get-faculty/{facultyId}")
	public Faculty getFacultyById(@PathVariable int facultyId) {
		return facultyService.getFacultyById(facultyId);

	}

	@PostMapping("/update")
	public String updateFaculty(@RequestBody Faculty faculty) {
		return facultyService.updateFaculty(faculty);
	}

	@GetMapping("/delete/{facultyId}")
	public String deleteFaculty(@PathVariable int facultyId) {
		return facultyService.deleteFaculty(facultyId);
	}

	@GetMapping("/assign-subject/{facultyId}/{subjectId}")
	public String assignSubject(@PathVariable int facultyId, @PathVariable int subjectId) {
		return facultyService.assignSubject(facultyId, subjectId);
	}

	@GetMapping("/get-subject/{facultyId}")
	public Subject getSubject(@PathVariable int facultyId) {
		return facultyService.getSubject(facultyId);
	}

	@PostMapping("/update-phone-number/{facultyId}")
	public Faculty updatePhoneNumber(@PathVariable int facultyId, @RequestBody Faculty faculty) {
		return facultyService.updatePhoneNumber(facultyId, faculty);
	}

	@PostMapping("/update-email/{facultyId}")
	public Faculty updateEmail(@PathVariable int facultyId, @RequestBody Faculty faculty) {
		return facultyService.updateEmail(facultyId, faculty);
	}

	@PostMapping("/update-name/{facultyId}")
	public Faculty updateName(@PathVariable int facultyId, @RequestBody Faculty faculty) {
		return facultyService.updateName(facultyId, faculty);
	}

	@PostMapping("/change-password/{facultyId}/{phoneNo}")
	public String changePassword(@PathVariable int facultyId, @PathVariable String phoneNo,
			@RequestBody Faculty faculty) {
		return facultyService.changePassword(facultyId, phoneNo, faculty);
	}

	@PostMapping("/change-password-by-email/{facultId}/{email}")
	public String changePasswordByEmail(@PathVariable int facultyId, @PathVariable String email,
			@RequestBody Faculty faculty) {
		return facultyService.changePasswordByEmail(facultyId, email, faculty);
	}
	
	
	@PostMapping("/change-username/{facultyId}/{phoneNo}")
	public String changeUsername(@PathVariable int facultyId, @PathVariable String phoneNo,
			@RequestBody Faculty faculty) {
		return facultyService.changeUsername(facultyId, phoneNo, faculty);
	}

	@PostMapping("/change-username-by-email/{facultId}/{email}")
	public String changeUsernameByEmail(@PathVariable int facultyId, @PathVariable String email,
			@RequestBody Faculty faculty) {
		return facultyService.changeUsernameByEmail(facultyId, email, faculty);
	}

	@GetMapping("/{facultyId}/exams")
	public List<Exam> getExamsForFaculty(@PathVariable int facultyId) {
		return facultyService.getExamsForFaculty(facultyId);
	}

	@PostMapping("/{examId}/assign-faculty")
	public String assignFacultyToExam(@PathVariable int examId, @RequestBody int facultyId) {
		return facultyService.assignFacultyToExam(examId, facultyId);
	}

	@PostMapping("/{examId}/remove-faculty/{facultyId}")
	public String removeFacultyFromExam(@PathVariable int examId, @PathVariable int facultyId) {
		return facultyService.removeFacultyFromExam(examId, facultyId);
	}


	@GetMapping("/faculty-by-username/{userName}")
	public Faculty getFacultyByUsername(@PathVariable String userName) {
		return facultyService.getFacultytByUserName(userName);
	}
	

	@GetMapping("/faculty-by-email/{email}")
	public Faculty getFacultyByEmail(@PathVariable String email) {
		return facultyService.getFacultytByEmail(email);
	}
	
	

}
