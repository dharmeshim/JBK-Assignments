package com.dpr.examiner.dao;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityNotFoundException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Faculty;
import com.dpr.examiner.model.Result;
import com.dpr.examiner.model.Student;

@Repository
public class ExamDao {

	@Autowired
	SessionFactory factory;

	public List<Exam> getExams() {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Exam.class);
		List<Exam> exams = criteria.list();
		session.close();
		return exams;

	}

	public List<Exam> getExamByName(String examName) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Exam.class);
		criteria.add(Restrictions.eq("examName", examName));
		List<Exam> exams = criteria.list();
		session.close();
		return exams;
	}
	
	
	

	public Exam getExamById(int examId) {
		Session session = factory.openSession();
		Exam exam = session.get(Exam.class, examId);
		session.close();
		return exam;
	}

	public String deleteExam(int examId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Exam exam = session.get(Exam.class, examId);

		if (exam != null) {
			session.delete(exam);
			tx.commit();
			session.close();
			return "Student with ID " + examId + " deleted successfully.";
		} else {
			tx.rollback();
			session.close();
			return "Student with ID " + examId + " not found.";
		}
	}

	/////////////////////////////////

	public Exam updateExam(Exam exam) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(exam);
		tx.commit();
		session.close();
		return exam;
	}

	public String assignStudentsToExam(int examId, List<Integer> studentIds) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			Criteria studentCriteria = session.createCriteria(Student.class);
			studentCriteria.add(Restrictions.in("studentId", studentIds));
			List<Student> students = studentCriteria.list();

			if (students.isEmpty()) {
				throw new EntityNotFoundException("No students found with the provided IDs");
			}

			exam.getAssignedStudents().addAll(students);
			session.update(exam);

			tx.commit();
			return "Students assigned to the exam successfully.";
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public String removeStudentsFromExam(int examId, List<Integer> studentIds) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			List<Student> studentsToRemove = new ArrayList<>();
			for (Integer studentId : studentIds) {
				Student student = session.get(Student.class, studentId);
				if (student != null) {
					studentsToRemove.add(student);
				}
			}

			if (studentsToRemove.isEmpty()) {
				throw new EntityNotFoundException("No students found with the provided IDs");
			}

			exam.getAssignedStudents().removeAll(studentsToRemove);
			session.update(exam);

			tx.commit();
			return "Students removed from the exam successfully.";
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public List<Student> getAssignedStudents(int examId) {
		Session session = factory.openSession();

		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			List<Student> assignedStudents = exam.getAssignedStudents();

			return assignedStudents;
		} finally {
			session.close();
		}
	}

	public String assignStudentToExam(int examId, int studentId) {
		try (Session session = factory.openSession()) {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				return ("Exam not found");
			}

			Student student = session.get(Student.class, studentId);
			if (student == null) {
				return ("Student not found");
			}

			exam.getAssignedStudents().add(student);

			session.update(exam);
			return "assigned successfully";
		} catch (Exception e) {
			throw e;
		}

	}

	public List<Exam> findAllSortedByTimeAsc() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Exam.class);
			criteria.addOrder(Order.asc("startTime"));
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Exam> findAllSortedByTimeDesc() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Exam.class);
			criteria.addOrder(Order.desc("startTime"));
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Exam> findAllSortedByIdAsc() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Exam.class);
			criteria.addOrder(Order.asc("examId"));
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Exam> findAllSortedByIdDesc() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Exam.class);
			criteria.addOrder(Order.desc("examId"));
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
	}

	public String addFacultyToExam(int examId, int facultyId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			Faculty faculty = session.get(Faculty.class, facultyId);
			if (faculty == null) {
				throw new EntityNotFoundException("Faculty not found");
			}

			exam.setFaculty(faculty);

			session.update(exam);

			tx.commit();
			return "Faculty added to the exam successfully.";
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public String removeFacultyFromExam(int examId, int facultyId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			Faculty faculty = exam.getFaculty();
			if (faculty == null || faculty.getFacultyId() != facultyId) {
				throw new EntityNotFoundException("Faculty not found for this exam");
			}

			exam.setFaculty(null);

			session.update(exam);

			tx.commit();
			return "Faculty removed from the exam successfully.";
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public String removeStudentFromExam(int examId, int studentId) {
		Session session = factory.openSession();

		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			Student student = session.get(Student.class, studentId);
			if (student == null) {
				throw new EntityNotFoundException("Student not found");
			}

			exam.getAssignedStudents().remove(student);

			session.update(exam);

			return "Student removed from the exam successfully.";
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	public String changeFacultyForExam(int examId, int newFacultyId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			Faculty newFaculty = session.get(Faculty.class, newFacultyId);
			if (newFaculty == null) {
				throw new EntityNotFoundException("New faculty not found");
			}

			exam.setFaculty(newFaculty);

			session.update(exam);

			tx.commit();
			return "Faculty changed for the exam successfully.";
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public List<Faculty> getAssignedFaculty(int examId) {
		try (Session session = factory.openSession()) {
			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				throw new EntityNotFoundException("Exam not found");
			}

			Faculty assignedFaculty = exam.getFaculty();

			List<Faculty> assignedFacultyList = new ArrayList<>();
			if (assignedFaculty != null) {
				assignedFacultyList.add(assignedFaculty);
			}

			return assignedFacultyList;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Result> getResultsById(int examId) {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Result.class);
			criteria.add(Restrictions.eq("examId", examId));

			List<Result> results = criteria.list();

			return results;
		} catch (Exception e) {
			throw e;
		}
	}

}
