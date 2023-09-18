package com.dpr.examiner.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dpr.examiner.model.Result;
import com.dpr.examiner.model.Student;
import com.dpr.examiner.model.Subject;

@Repository
public class ResultDao {

	@Autowired
	SessionFactory sessionFactory;

	public List<Result> getAllResults() {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Result.class);
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
	}

	public Result createResult(Result result) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.save(result);
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	public Result getResultById(Long resultId) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Result.class);
			criteria.add(Restrictions.eq("resultId", resultId));
			return (Result) criteria.uniqueResult();
		} catch (Exception e) {
			throw e;
		}
	}

	public Result updateResult(Long resultId, Result updatedResult) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Result.class);
			criteria.add(Restrictions.eq("resultId", resultId));
			Result existingResult = (Result) criteria.uniqueResult();

			if (existingResult != null) {

				session.update(updatedResult);

				tx.commit();
				return existingResult;
			} else {
				tx.rollback();
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String deleteResult(Long resultId) {
		try (Session session = sessionFactory.openSession()) {
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Result.class);
			criteria.add(Restrictions.eq("resultId", resultId));
			Result existingResult = (Result) criteria.uniqueResult();

			if (existingResult != null) {
				session.delete(existingResult);
				tx.commit();
				return "Result with ID " + resultId + " has been deleted successfully.";
			} else {
				tx.rollback();
				return "Result with ID " + resultId + " not found.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Result> getResultsByStudentId(int studentId) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Result.class);
			criteria.add(Restrictions.eq("studentId", studentId));
			List<Result> results = criteria.list();
			return results;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Result> getResultsByExamId(int examId) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(Result.class);
			criteria.add(Restrictions.eq("examId", examId));

			List<Result> results = criteria.list();

			return results;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Result> getResultsByStudentName(String studentName) {
		Session session = sessionFactory.openSession();
		try {
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.ilike("studentName", studentName));
			return criteria.list();
		} finally {
			session.close();
		}
	}

	public List<Result> getResultsByStudentPhone(String phoneNumber) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Result.class).createAlias("student", "s")
				.add(Restrictions.eq("s.phoneNumber", phoneNumber));

		List<Result> results = criteria.list();
		session.close();
		return results;
	}

	public List<Result> getResultsByStudentEmail(String email) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Result.class).createAlias("student", "s")
				.add(Restrictions.eq("s.email", email));

		List<Result> results = criteria.list();
		session.close();
		return results;
	}

	public List<Result> getResultsByExamName(String examName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Result.class)
				.createAlias("exam", "e") 
				.add(Restrictions.eq("e.examName", examName));

		@SuppressWarnings("unchecked")
		List<Result> results = criteria.list();
		return results;
	}
	public List<Result> getResultsBySubject(int subjectId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Result.class)
                .createAlias("exam", "e") 
                .createAlias("e.subjects", "s")  
                .add(Restrictions.eq("s.subjectId", subjectId));

        @SuppressWarnings("unchecked")
        List<Result> results = criteria.list();
        return results;
    }
	
	 public List<Result> getResultsByFaculty(int facultyId) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(Result.class)
	                .createAlias("exam", "e")  
	                .createAlias("e.faculty", "f")  
	                .add(Restrictions.eq("f.facultyId", facultyId));

	        @SuppressWarnings("unchecked")
	        List<Result> results = criteria.list();
	        return results;
	    }
	 
	 public List<Result> getResultsAboveMarks(double minMarks) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(Result.class);
	        criteria.add(Restrictions.ge("marks", minMarks)); 
	        List<Result> results = criteria.list();
	        return results;
	    }
	 
	 public List<Result> getResultsBelowMarks(double maxMarks) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria criteria = session.createCriteria(Result.class);
	        criteria.add(Restrictions.le("marks", maxMarks)); 
	        List<Result> results = criteria.list();
	        return results;
	    }
	
}
