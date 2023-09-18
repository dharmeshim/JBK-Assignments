package com.dpr.examiner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Result;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	@PostMapping("/save")
	public String saveUser(@RequestBody Student user) {
		return studentService.saveStudent(user);

	}

	@GetMapping("/get-all-students")
	public List<Student> getAllStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/get-student/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		return studentService.getStudentById(studentId);

	}

	@GetMapping("/get-student-name/{studentName}")
	public List<Student> getStudentByName(@PathVariable String studentName) {
		return studentService.getStudentByName(studentName);
	}

	@PostMapping("/update")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@GetMapping("delete/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		return studentService.deleteStudent(studentId);
	}

	@GetMapping("/sorted-by-id")
	public List<Student> getAllStudentsSortedByIdAsc() {
		return studentService.getAllStudentsSortedByIdAsc();
	}

	@GetMapping("/sorted-by-id-desc")
	public List<Student> getAllStudentsSortedByIdDesc() {
		return studentService.getAllStudentsSortedByIdDesc();
	}

	@GetMapping("/sorted-by-name")
	public List<Student> getAllStudentsSortedByNameAsc() {
		return studentService.getAllStudentsSortedByNameAsc();
	}

	@GetMapping("/sorted-by-name-desc")
	public List<Student> getAllStudentsSortedByNameDesc() {
		return studentService.getAllStudentsSortedByNameDesc();
	}

	@PostMapping("/enroll-exam/{studentId}/{examId}")
	public ResponseEntity<String> enrollStudentInExam(@PathVariable int studentId, @PathVariable int examId) {
		String result = studentService.enrollStudentInExam(studentId, examId);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/update-phone-number/{studentId}")
	public Student updatePhoneNumber(@PathVariable int studentId, @RequestBody Student student) {
		return studentService.updatePhoneNumber(studentId, student);
	}

	@PostMapping("/update-email/{studentId}")
	public Student updateEmail(@PathVariable int studentId, @RequestBody Student student) {
		return studentService.updateEmail(studentId, student);
	}

	@PostMapping("/update-name/{studentId}")
	public Student updateName(@PathVariable int studentId, @RequestBody Student student) {
		return studentService.updateName(studentId, student);
	}

	@PostMapping("/change-password/{studentId}/{phoneNo}")
	public String changePassword(@PathVariable int studentId, @PathVariable String phoneNo,
			@RequestBody Student student) {
		return studentService.changePassword(studentId, phoneNo, student);
	}

	
	@PostMapping("/change-password-by-email/{studentId}/{email}")
	public String changePasswordByEmail(@PathVariable int studentId, @PathVariable String email,
			@RequestBody Student student) {
		return studentService.changePasswordByEmail(studentId, email, student);
	}
	
	 @PostMapping("/leave-exam/{studentId}/{examId}")
	    public ResponseEntity<String> leaveExam(@PathVariable int studentId, @PathVariable int examId) {
	        String result = studentService.leaveExam(studentId, examId);
	        return ResponseEntity.ok(result);
	    }
	
	
	@GetMapping("/{studentId}/exams")
	public List<Exam> getExamsForStudent(@PathVariable int studentId) {
	    return studentService.getExamsForStudent(studentId);
	}

	@GetMapping("/student-id/{studentId}")
	public List<Result> getResultsByStudentId(@PathVariable int studentId) {
	    return studentService.getResultsByStudentId(studentId);
	}
	
	

	@GetMapping("/student-by-username/{userName}")
	public Student getStudentByUsername(@PathVariable String userName) {
		return studentService.getStudentByUserName(userName);
	}


	@GetMapping("/student-by-email/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return studentService.getStudentByEmail(email);
	}

}
