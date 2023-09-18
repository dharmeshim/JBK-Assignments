package com.dpr.examiner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpr.examiner.model.Result;
import com.dpr.examiner.service.ResultService;

@RestController
@RequestMapping("/results")
public class ResultController {
	
	
	private final ResultService resultService;
	
	@Autowired
	public ResultController(ResultService resultService) {
		this.resultService=resultService;
	}
	
	
	@GetMapping("/get-result")
	public List<Result> getAllResults() {
	    return resultService.getAllResults();
	}
	
	@PostMapping("/create")
	public Result createResult(@RequestBody Result result) {
	    return resultService.createResult(result);
	}
	
	@GetMapping("/results-by-id/{resultId}")
	public Result getResultById(@PathVariable Long resultId) {
	   return resultService.getResultById(resultId);
	   
	}
	
	@PostMapping("/update-result/{resultId}")
	public Result updateResult(@PathVariable Long resultId, @RequestBody Result updatedResult) {
	    return resultService.updateResult(resultId, updatedResult);
	 
	}

	@PostMapping("/delete-by-id/{resultId}")
	public String deleteResult(@PathVariable Long resultId) {
	  return resultService.deleteResult(resultId);
	}
	
	@GetMapping("/student-id/{studentId}")
	public List<Result> getResultsByStudentId(@PathVariable int studentId) {
	    return resultService.getResultsByStudentId(studentId);
	}

	@GetMapping("/exam-id/{examId}")
	public List<Result> getResultsByExamId(@PathVariable int examId) {
	    return resultService.getResultsByExamId(examId);
	}


	@GetMapping("/passed-students")
	public List<Result> getPassedStudents() {
	    return resultService.getPassedStudents();
	}
	
	

	@GetMapping("/failed-students")
	public List<Result> getFailedStudents() {
	    return resultService.getFailedStudents();
	}
	
	 @GetMapping("/students-above-score/{mark}")
	    public List<Result> getStudentsAboveScore(@PathVariable double mark) {
	        return resultService.getStudentsAboveScore(mark);
	    }
	 
	 
	 @GetMapping("/top-scorers/{count}")
	 public List<Result> getTopScorers(@PathVariable int count) {
	     return resultService.getTopScorers(count);
	 }
	 
	 @GetMapping("/get-results-by-exam-name/{examName}")
	 public List<Result> getResultsByExamName(@PathVariable String examName) {
	     return resultService.getResultsByExamName(examName);
	 }

	 @GetMapping("/get-results-by-subject/{subjectId}")
	 public List<Result> getResultsBySubject(@PathVariable int subjectId) {
	     return resultService.getResultsBySubject(subjectId);
	 }


	 @GetMapping("/perfet-scorers")
	 public List<Result> getPerfectScorers() {
		 return resultService.getPerfectScorers();
	 }
	
	 
	 @GetMapping("/get-results-by-student-name/{studentName}")
	    public List<Result> getResultsByStudentName(@PathVariable String studentName) {
	        return resultService.getResultsByStudentName(studentName);
	    }
	 
	 @GetMapping("/get-results-by-student-phone/{phoneNumber}")
	    public List<Result> getResultsByStudentPhone(@PathVariable String phoneNumber) {
	        return resultService.getResultsByStudentPhone(phoneNumber);
	    }
	

	 @GetMapping("/get-results-by-student-email/{email}")
	    public List<Result> getResultsByStudentEmail(@PathVariable String email) {
	        return resultService.getResultsByStudentEmail(email);
	    }

	 @GetMapping("/get-results-by-faculty/{facultyId}")
	 public List<Result> getResultsByFaculty(@PathVariable int facultyId) {
	     return resultService.getResultsByFaculty(facultyId);
	 }
	 
	 @GetMapping("/get-results-above-marks/{minMarks}")
	 public List<Result> getResultsAboveMarks(@PathVariable double minMarks) {
	     return resultService.getResultsAboveMarks(minMarks);
	 }

	 @GetMapping("/get-results-below-marks/{maxMarks}")
	 public List<Result> getResultsBelowMarks(@PathVariable double maxMarks) {
	     return resultService.getResultsBelowMarks(maxMarks);
	 }


}
