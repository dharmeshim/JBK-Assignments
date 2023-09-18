package com.dpr.examiner.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Faculty;
import com.dpr.examiner.model.Result;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.service.ExamServiceImpl;

@RestController
@RequestMapping("/exams")
public class ExamController {
	private final ExamServiceImpl examService;

	@Autowired
	public ExamController(ExamServiceImpl examService) {
		this.examService = examService;
	}

	@PostMapping("/set")
	public Exam setExam(@RequestBody Exam exam) {
		// Add logic
		return examService.createExam(exam);
	}

	@GetMapping("/get-all-exams")
	public List<Exam> getAllExams() {
		return examService.getAllExams();
	}

	@GetMapping("/get-all-exams-sor-by-time")
	public List<Exam> getAllExamsByTime() {
		return examService.getAllExamsByTime();
	}

	@GetMapping("/get-all-exams-sor-by-time-desc")
	public List<Exam> getAllExamsByTimeDesc() {
		return examService.getAllExamsByTimeDesc();
	}

	@GetMapping("/get-exam-name/{examName}")
	public List<Exam> getStudentByName(@PathVariable String examName) {
		return examService.getExamByName(examName);
	}

	@GetMapping("/get-exam/{examId}")
	public Exam getExamById(@PathVariable int examId) {
		return examService.getExamById(examId);

	}

	@GetMapping("/delete/{examId}")
	public String deleteExam(@PathVariable int examId) {
		return examService.deleteExam(examId);
	}

	@PostMapping("/update")
	public Exam updateExam(@RequestBody Exam exam) {
		return examService.updateExam(exam);
	}

	@PostMapping("/{examId}/assign-students")
	public String assignStudentsToExam(@PathVariable int examId, @RequestBody Map<String, List<Integer>> requestBody) {
		List<Integer> studentIds = requestBody.get("studentIds");

		return examService.assignStudentsToExam(examId, studentIds);
	}

	@PostMapping("/{examId}/assign-student/{studentId}")
	public String assignStudentToExam(@PathVariable int examId, @PathVariable int studentId) {

		return examService.assignStudentToExam(examId, studentId);
	}

	@GetMapping("/{examId}/remove-students")
	public String removeStudentsFromExam(@PathVariable int examId,
			@RequestBody Map<String, List<Integer>> requestBody) {
		List<Integer> studentIds = requestBody.get("studentIds");

		return examService.removeStudentsFromExam(examId, studentIds);
	}

	
	@GetMapping("/{examId}/remove-student/{studentId}")
	public String removeStudentFromExam(@PathVariable int examId, @PathVariable int studentId) {
	    return examService.removeStudentFromExam(examId, studentId);
	}

	
	
	@GetMapping("/{examId}/get-assigned-students")
	public List<Student> getAssignedStudents(@PathVariable int examId) {
		return examService.getAssignedStudents(examId);
	}

	@PostMapping("/{examId}/add-faculty/{facultyId}")
	public String addFacultyToExam(@PathVariable int examId, @PathVariable int facultyId) {
		return examService.addFacultyToExam(examId, facultyId);
	}

	@PostMapping("/{examId}/remove-faculty/{facultyId}")
	public String removeFacultyFromExam(@PathVariable int examId, @PathVariable int facultyId) {
		return examService.removeFacultyFromExam(examId, facultyId);
	}

	@PostMapping("/{examId}/change-faculty/{facultyId}")
	public String changeFacultyForExam(@PathVariable int examId, @PathVariable int facultyId) {
		return examService.changeFacultyForExam(examId, facultyId);
	}

	@GetMapping("/{examId}/get-assigned-faculty")
	public List<Faculty> getAssignedFaculty(@PathVariable int examId) {
		return examService.getAssignedFaculty(examId);
	}

	@GetMapping("/get-all-exams-sorted-by-examId-asc")
	public List<Exam> getAllExamsSortedByExamIdAsc() {
		return examService.getAllExamsById();
	}

	@GetMapping("/get-all-exams-sorted-by-examId-desc")
	public List<Exam> getAllExamsSortedByExamIdDesc() {
		return examService.getAllExamsByIdDesc();
	}
	
	@GetMapping("/exam-id/{examId}")
	public List<Result> getResultsByExamId(@PathVariable int examId) {
	    return examService.getResultsByExamId(examId);
	}

}
