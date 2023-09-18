package com.dpr.examiner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpr.examiner.dao.ExamRoomDao;
import com.dpr.examiner.model.ExamRoom;

@Service
public class ExamRoomService {
	
	private final ExamRoomDao examRoomDao;
	
	@Autowired
	public ExamRoomService(ExamRoomDao examRoomDao) {
		this.examRoomDao=examRoomDao;
	}

	public List<ExamRoom> getAllExamRooms() {
		return examRoomDao.getAllExamRooms();
	}

	public ExamRoom getExamRoomById(int examRoomId) {
		return examRoomDao.getExamRoomById(examRoomId);
	}

	public ExamRoom createExamRoom(ExamRoom examRoom) {
		return examRoomDao.createExamRoom(examRoom);
	}

	public ExamRoom updateExamRoom(int examRoomId, ExamRoom updatedExamRoom) {
		return examRoomDao.updateExamRoom(examRoomId, updatedExamRoom);
	}

	public String deleteExamRoom(int examRoomId) {
		return examRoomDao.deleteExamRoom(examRoomId);
	}

	public List<ExamRoom> getAvailableExamRooms() {
		return examRoomDao.getAvailableExamRooms();
	}

	public List<ExamRoom> searchExamRoomsByRoomNumber(int roomNumber) {
		// TODO Auto-generated method stub
		return examRoomDao.searchExamRoomsByRoomNumber(roomNumber);
	}

	public List<ExamRoom> getExamRoomsByCapacity(int seatingCapacity) {
		// TODO Auto-generated method stub
		return examRoomDao.getExamRoomsByCapacity(seatingCapacity);
	}

	public List<ExamRoom> getExamRoomsByDateOfAvailability(String date) {
		// TODO Auto-generated method stub
		return examRoomDao.getExamRoomsByDateOfAvailability(date);
	}

	public List<ExamRoom> getExamRoomsByBlock(String block) {
		// TODO Auto-generated method stub
		return examRoomDao.getExamRoomsByBlock(block);
	}

	public List<ExamRoom> getExamRoomsByRoomType(String roomType) {
		// TODO Auto-generated method stub
		return examRoomDao.getExamRoomsByRoomType(roomType);
	}

	public List<ExamRoom> getExamRoomsByFloor(String floor) {
		// TODO Auto-generated method stub
		return examRoomDao.getExamRoomsByFloor(floor);
	}

	public List<ExamRoom> getExamRoomsWithAmenities(String amenity) {
		// TODO Auto-generated method stub
		return examRoomDao.getExamRoomsWithAmenities(amenity);
	}

	public List<ExamRoom> searchExamRoomsByDescriptionKeyword(String keyword) {
		// TODO Auto-generated method stub
		return examRoomDao.searchExamRoomsByDescriptionKeyword(keyword);
	}
	
	 public ExamRoom reserveExamRoom(int examRoomId, String reservationDate, String reservationTime) {
	       
	        ExamRoom reservedExamRoom = examRoomDao.getExamRoomById(examRoomId);
	        reservedExamRoom.setAvailable(false);
	        examRoomDao.updateExamRoom(examRoomId, reservedExamRoom);
	        
	        return reservedExamRoom;
	    }
	

}
