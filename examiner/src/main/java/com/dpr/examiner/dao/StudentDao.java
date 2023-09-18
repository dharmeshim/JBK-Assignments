package com.dpr.examiner.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Result;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.model.Subject;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public List<Student> getStudents() throws DataAccessException {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		session.close();
		return students;
	}

	public List<Student> getStudentByName(String name) throws DataAccessException {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("studentName", name));
		List<Student> students = criteria.list();
		session.close();
		return students;
	}

	public Student getStudentById(int id) throws DataAccessException {
		Session session = factory.openSession();
		Student student = session.get(Student.class, id);
		session.close();
		return student;
	}

	@Transactional
	public String insertStudent(Student student) throws DataAccessException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
		return "Student inserted into the table successfully.";
	}

	@Transactional
	public String deleteStudent(int id) throws DataAccessException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, id);

		if (student != null) {
			session.delete(student);
			tx.commit();
			session.close();
			return "Student with ID " + id + " deleted successfully.";
		} else {
			tx.rollback();
			session.close();
			return "Student with ID " + id + " not found.";
		}
	}

	@Transactional
	public String updateStudent(Student student) throws DataAccessException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
		session.close();
		return "Student updated in the table successfully.";
	}

	public Student updatePhoneNumber(int studentId, String phoneNumber) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Student student = session.get(Student.class, studentId);
		student.setPhoneNumber(phoneNumber);
		session.beginTransaction().commit();
		return student;
	}

	public Student updateEmail(int studentId, String newEmail) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Student student = session.get(Student.class, studentId);
		student.setStudentEmail(newEmail);
		session.beginTransaction().commit();
		return student;
	}

	public Student updateStudentName(int studentId, String newName) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Student student = session.get(Student.class, studentId);
		student.setStudentName(newName);
		session.beginTransaction().commit();
		return student;
	}

	public String updatePasswordbyPhone(int studentId, String newPassword) {

		Session session = factory.openSession();
		Student student = session.get(Student.class, studentId);
		student.setPassword(newPassword);
		session.beginTransaction().commit();
		return "changed";

	}

	public String updatePasswordByEmail(int studentId, String newPassword) {

		Session session = factory.openSession();
		Student student = session.get(Student.class, studentId);
		student.setStudentEmail(newPassword);
		session.beginTransaction().commit();
		return "changed by email";

	}

	public List<Exam> getExamsForStudent(int studentId) {
		Session session = factory.openSession();

		try {
			Criteria criteria = session.createCriteria(Exam.class);
			criteria.createAlias("assignedStudents", "student");
			criteria.add(Restrictions.eq("student.studentId", studentId));
			List<Exam> exams = criteria.list();

			return exams;
		} finally {
			session.close();
		}
	}

	public String removeStudentFromExam(int studentId, int examId) {
		Session session = factory.openSession();
		Criteria studentCriteria = session.createCriteria(Student.class);
		studentCriteria.add(Restrictions.eq("studentId", studentId));
		Student student = (Student) studentCriteria.uniqueResult();

		if (student != null) {
			Criteria examCriteria = session.createCriteria(Exam.class);
			examCriteria.add(Restrictions.eq("examId", examId));
			Exam exam = (Exam) examCriteria.uniqueResult();

			if (exam != null) {
				exam.getAssignedStudents().remove(student);
				session.beginTransaction();
				session.saveOrUpdate(exam);
				session.getTransaction().commit();
				session.close();
				
				return "remove success";
			} else {
				return "exam not found";
			}
		} else {
			return "student not found";
		}
		

	}

	public List<Result> getResultsByStudentId(int studentId) {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Result.class);
			criteria.add(Restrictions.eq("studentId", studentId));
			List<Result> results = criteria.list();
			return results;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	public Student getStudentByUsername(String userName) throws DataAccessException {
		Session session = factory.openSession();
		Student student = session.get(Student.class, userName);
		session.close();
		return student;
	}
	

	public Student getStudentByEmail(String email) throws DataAccessException {
		Session session = factory.openSession();
		Student student = session.get(Student.class, email);
		session.close();
		return student;
	}
	

}
