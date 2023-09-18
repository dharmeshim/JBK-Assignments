package com.dpr.examiner.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dpr.examiner.model.Exam;
import com.dpr.examiner.model.Faculty;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.model.Subject;

@Repository
public class FacultyDao {

	@Autowired
	SessionFactory factory;

	@Transactional
	public String insertFaculty(Faculty faculty) throws DataAccessException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(faculty);
		tx.commit();
		session.close();
		return "faculty inserted into the table successfully.";
	}

	public List<Faculty> getFaculties() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Faculty.class);
		criteria.setFetchMode("subject", FetchMode.EAGER);
		List<Faculty> faculties = criteria.list();
		session.close();
		return faculties;
	}

	public Faculty getFacultyById(int facultyId) {
		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyId);
		session.close();
		return faculty;
	}

	@Transactional
	public String updateFaculty(Faculty faculty) throws DataAccessException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(faculty);
		tx.commit();
		session.close();
		return "faculty updated in the table successfully.";
	}

	@Transactional
	public String deleteFaculty(int facultyId) throws DataAccessException {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Faculty faculty = session.get(Faculty.class, facultyId);

		if (faculty != null) {
			session.delete(faculty);
			tx.commit();
			session.close();
			return "Faculty with ID " + facultyId + " deleted successfully.";
		} else {
			tx.rollback();
			session.close();
			return "Faculty with ID " + facultyId + " not found.";
		}
	}

	public String assignSubject(int facultyId, int subjectId) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Faculty faculty = session.get(Faculty.class, facultyId);
		Subject subject = session.get(Subject.class, subjectId);

		faculty.setSubject(subject);
		subject.setFaculty(faculty);

		session.saveOrUpdate(faculty);
		session.saveOrUpdate(subject);
		tx.commit();
		session.close();
		return "subject assigned successfully.";

	}

	public Subject getSubject(int facultyId) {
		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyId);
		Subject facultySubject = faculty.getSubject();
		session.close();
		return facultySubject;
	}

	public Faculty updatePhoneNumber(int facultyId, long phoneNumber) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyId);
		faculty.setPhoneNumber(phoneNumber);
		session.beginTransaction().commit();
		return faculty;
	}

	public Faculty updateEmail(int facultyID, String newEmail) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyID);
		faculty.setEmail(newEmail);
		session.beginTransaction().commit();
		return faculty;
	}

	public Faculty updateStudentName(int facultyID, String newName) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyID);
		faculty.setFacultyName(newName);
		session.beginTransaction().commit();
		return faculty;
	}

	public String updatePasswordbyPhone(int facultyId, String newPassword) {

		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyId);
		faculty.setPassword(newPassword);
		session.beginTransaction().commit();
		return "changed";

	}

	public String updatePasswordByEmail(int facultyId, String newPassword) {

		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyId);
		faculty.setPassword(newPassword);
		session.beginTransaction().commit();
		return "changed by email";

	}
	
	public String updateUsernamebyPhone(int facultyId, String newUsername) {

		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyId);
		faculty.setUserName(newUsername);
		session.beginTransaction().commit();
		return "changed";

	}

	public String updateUsernameByEmail(int facultyId, String newUsername) {

		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, facultyId);
		faculty.setUserName(newUsername);
		session.beginTransaction().commit();
		return "changed by email";

	}

	public List<Exam> getExamsForFaculty(int facultyId) {
		Session session = factory.openSession();

		try {
			Criteria criteria = session.createCriteria(Exam.class);
			criteria.add(Restrictions.eq("faculty.facultyId", facultyId));
			List<Exam> exams = criteria.list();

			return exams;
		} finally {
			session.close();
		}
	}

	public String assignFacultyToExam(int examId, int facultyId) {
		Session session = factory.openSession();
		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				return "Exam not found";
			}

			Faculty faculty = session.get(Faculty.class, facultyId);
			if (faculty == null) {
				return "Faculty not found";
			}

			exam.setFaculty(faculty);

			session.beginTransaction();
			session.update(exam);
			session.getTransaction().commit();

			return "Faculty assigned to the exam successfully.";
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public String removeFacultyFromExam(int examId, int facultyId) {
		Session session = factory.openSession();
		try {

			Exam exam = session.get(Exam.class, examId);
			if (exam == null) {
				return "Exam not found";
			}

			Faculty faculty = session.get(Faculty.class, facultyId);
			if (faculty == null) {
				return "Faculty not found";
			}

			exam.setFaculty(null);

			session.beginTransaction();
			session.update(exam);
			session.getTransaction().commit();

			return "Faculty removed from the exam successfully.";
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Faculty getFacultyByUsername(String userName) throws DataAccessException {
		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, userName);
		session.close();
		return faculty;
	}

	public Faculty getFacultyByEmail(String email) throws DataAccessException {
		Session session = factory.openSession();
		Faculty faculty = session.get(Faculty.class, email);
		session.close();
		return faculty;
	}
	
	
	public List<Subject> getSubjectsByFaculty(int facultyId) {
	    Session session = factory.getCurrentSession();
	    Criteria criteria = session.createCriteria(Subject.class);
	    criteria.createAlias("assignedFaculties", "faculty");
	    criteria.add(Restrictions.eq("faculty.facultyId", facultyId));
	    List<Subject> subjects = criteria.list();
	    return subjects;
	}

}
