package com.dpr.examiner.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
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
import com.dpr.examiner.model.Subject;

@Repository
public class SubjectDao {

	@Autowired
	private SessionFactory factory;

	// Create a new subject
	public Subject createSubject(Subject subject) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(subject);
		tx.commit();
		session.close();
		return subject;
	}

	// Get all subjects
	public List<Subject> getAllSubjects() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.setFetchMode("subject", FetchMode.EAGER);
		List<Subject> subjects = criteria.list();
		session.close();
		return subjects;
	}

	// Get a subject by ID
	public Subject getSubjectById(int subjectId) {
		Session session = factory.openSession();
		Subject subject = session.get(Subject.class, subjectId);
		session.close();
		return subject;
	}

	// Update a subject by ID
	public Subject updateSubject(int subjectId, Subject updatedSubject) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(updatedSubject);
		tx.commit();
		session.close();
		return updatedSubject;
	}

	// Delete a subject by ID
	public String deleteSubject(int subjectId) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Subject subject = session.get(Subject.class, subjectId);

		if (subject != null) {
			session.delete(subject);
			tx.commit();
			session.close();
			return "Subject with ID " + subjectId + " deleted successfully.";
		} else {
			tx.rollback();
			session.close();
			return "subject with ID " + subjectId + " not found.";
		}
	}

	public List<Subject> getallSubjectsById() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Subject.class);
			criteria.addOrder(Order.asc("subjectId"));
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Subject> getSubjectByIdDEsc() {
		try (Session session = factory.openSession()) {
			Criteria criteria = session.createCriteria(Subject.class);
			criteria.addOrder(Order.desc("subjectId"));
			return criteria.list();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Subject> searchSubjectsByName(String keyword) {
		Session session = factory.openSession();
		try {
			Criteria criteria = session.createCriteria(Subject.class);
			criteria.add(Restrictions.ilike("subjectName", "%" + keyword + "%"));
			return criteria.list();
		} finally {
			session.close();
		}
	}

	public List<Subject> getSubjectsByCredits(int credits) {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Subject.class);
		criteria.add(Restrictions.eq("credits", credits));
		return criteria.list();

	}
	
	
	public List<Subject> getSubjectBelowCredits(double maxCredit) {
        Session session = factory.getCurrentSession();
        Criteria criteria = session.createCriteria(Subject.class);
        criteria.add(Restrictions.le("credits", maxCredit)); 
        List<Subject> subjects = criteria.list();
        return subjects;
    }

	public List<Subject> getSubjectAboveCredits(double minCredit) {
		 Session session = factory.getCurrentSession();
	        Criteria criteria = session.createCriteria(Subject.class);
	        criteria.add(Restrictions.ge("credits", minCredit)); 
	        List<Subject> subjects = criteria.list();
	        return subjects;
	}

}
