package com.dpr.examiner.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dpr.examiner.model.ExamRoom;

import java.util.List;

@Repository
@Transactional
public class ExamRoomDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<ExamRoom> getAllExamRooms() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		List<ExamRoom> examRooms = criteria.list();
		return examRooms;
	}

	public ExamRoom getExamRoomById(int examRoomId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		criteria.add(Restrictions.eq("examRoomId", examRoomId));
		return (ExamRoom) criteria.uniqueResult();
	}

	public ExamRoom createExamRoom(ExamRoom examRoom) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(examRoom);
		tx.commit();
		session.close();

		return examRoom;
	}

	public ExamRoom updateExamRoom(int examRoomId, ExamRoom updatedExamRoom) {
		Session session = sessionFactory.openSession();
		ExamRoom existingExamRoom = session.get(ExamRoom.class, examRoomId);

		if (existingExamRoom != null) {
			// Copy the updated values to the existing examRoom
			existingExamRoom.setRoomNumber(updatedExamRoom.getRoomNumber());
			existingExamRoom.setSeatingCapacity(updatedExamRoom.getSeatingCapacity());
			existingExamRoom.setAvailable(updatedExamRoom.isAvailable());
			existingExamRoom.setAddress(updatedExamRoom.getAddress());
			existingExamRoom.setBlock(updatedExamRoom.getBlock());
			existingExamRoom.setDateOfAvailable(updatedExamRoom.getDateOfAvailable());
			existingExamRoom.setAmenities(updatedExamRoom.getAmenities());
			existingExamRoom.setRoomType(updatedExamRoom.getRoomType());
			existingExamRoom.setFloor(updatedExamRoom.getFloor());
			existingExamRoom.setDescription(updatedExamRoom.getDescription());
			session.saveOrUpdate(existingExamRoom);
			return existingExamRoom;
		} else {
			return null;
		}
	}

	public String deleteExamRoom(int examRoomId) {
		Session session = sessionFactory.getCurrentSession();
		ExamRoom examRoom = session.get(ExamRoom.class, examRoomId);
		if (examRoom != null) {
			session.delete(examRoom);
			return "ExamRoom with ID " + examRoomId + " has been deleted.";
		} else {
			return "ExamRoom with ID " + examRoomId + " not found.";
		}
	}

	public List<ExamRoom> getAvailableExamRooms() {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(ExamRoom.class);
			criteria.add(Restrictions.eq("isAvailable", true));
			return criteria.list();
		}
	}

	public List<ExamRoom> searchExamRoomsByRoomNumber(int roomNumber) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(ExamRoom.class);
			criteria.add(Restrictions.eq("roomNumber", roomNumber));
			return criteria.list();
		}
	}

	public List<ExamRoom> getExamRoomsByCapacity(int seatingCapacity) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		criteria.add(Restrictions.ge("seatingCapacity", seatingCapacity));
		List<ExamRoom> examRooms = criteria.list();
		session.close();
		return examRooms;
	}

	public List<ExamRoom> getExamRoomsByDateOfAvailability(String date) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		criteria.add(Restrictions.eq("dateOfAvailable", date));
		List<ExamRoom> examRooms = criteria.list();
		session.close();
		return examRooms;
	}

	public List<ExamRoom> getExamRoomsByBlock(String block) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		criteria.add(Restrictions.eq("block", block));
		List<ExamRoom> examRooms = criteria.list();
		session.close();
		return examRooms;
	}

	public List<ExamRoom> getExamRoomsByRoomType(String roomType) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		criteria.add(Restrictions.eq("roomType", roomType));
		List<ExamRoom> examRooms = criteria.list();
		session.close();
		return examRooms;
	}

	public List<ExamRoom> getExamRoomsByFloor(String floor) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		criteria.add(Restrictions.eq("floor", floor));
		List<ExamRoom> examRooms = criteria.list();
		session.close();
		return examRooms;
	}

	public List<ExamRoom> getExamRoomsWithAmenities(String amenity) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);
		criteria.add(Restrictions.like("amenities", "%" + amenity + "%")); // Assuming "amenities" is a field containing
																			// amenities as a string
		List<ExamRoom> examRooms = criteria.list();
		session.close();
		return examRooms;
	}

	public List<ExamRoom> searchExamRoomsByDescriptionKeyword(String keyword) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ExamRoom.class);

		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like("description", "%" + keyword + "%"));
		disjunction.add(Restrictions.like("notes", "%" + keyword + "%")); // Assuming "notes" is a field containing
																			// additional notes

		criteria.add(disjunction);

		List<ExamRoom> examRooms = criteria.list();
		session.close();
		return examRooms;
	}

	public ExamRoom reserveExamRoom(int examRoomId, ExamRoom updatedExamRoom) {
		Session session = sessionFactory.openSession();
		ExamRoom existingExamRoom = session.get(ExamRoom.class, examRoomId);

		if (existingExamRoom != null) {
			existingExamRoom.setAvailable(updatedExamRoom.isAvailable());
		

			session.saveOrUpdate(existingExamRoom);

			session.close();

			return existingExamRoom;
		} else {
			session.close();
			return null;
		}
	}
}
