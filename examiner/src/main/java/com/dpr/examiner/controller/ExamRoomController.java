package com.dpr.examiner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpr.examiner.model.ExamRoom;
import com.dpr.examiner.service.ExamRoomService;

@RestController
@RequestMapping("/rooms")
public class ExamRoomController {

   
    private ExamRoomService examRoomService;
    
    @Autowired
    public ExamRoomController(ExamRoomService examRoomService) {
    	this.examRoomService=examRoomService;
    }

    @GetMapping("/all")
    public List<ExamRoom> getAllExamRooms() {
        return examRoomService.getAllExamRooms();
    }

    @GetMapping("/{examRoomId}")
    public ExamRoom getExamRoomById(@PathVariable int examRoomId) {
        return examRoomService.getExamRoomById(examRoomId);
    }

    @PostMapping("/create")
    public ExamRoom createExamRoom(@RequestBody ExamRoom examRoom) {
        return examRoomService.createExamRoom(examRoom);
    }

    @PutMapping("/update/{examRoomId}")
    public ExamRoom updateExamRoom(@PathVariable int examRoomId, @RequestBody ExamRoom updatedExamRoom) {
        return examRoomService.updateExamRoom(examRoomId, updatedExamRoom);
    }

    @DeleteMapping("/delete/{examRoomId}")
    public String deleteExamRoom(@PathVariable int examRoomId) {
        return examRoomService.deleteExamRoom(examRoomId);
    }
    
    @GetMapping("/available")
    public List<ExamRoom> getAvailableExamRooms() {
        return examRoomService.getAvailableExamRooms();
    }
    
    @GetMapping("/search/{roomNumber}")
    public List<ExamRoom> searchExamRoomsByRoomNumber(@PathVariable int roomNumber) {
        return examRoomService.searchExamRoomsByRoomNumber(roomNumber);
    }
    
    @GetMapping("/capacity/{seatingCapacity}")
    public List<ExamRoom> getExamRoomsByCapacity(@PathVariable int seatingCapacity) {
        return examRoomService.getExamRoomsByCapacity(seatingCapacity);
    }
    
    @GetMapping("/available-on/{date}")
    public List<ExamRoom> getExamRoomsByDateOfAvailability(@PathVariable String date) {
        return examRoomService.getExamRoomsByDateOfAvailability(date);
    }
    
    
    @GetMapping("/block/{block}")
    public List<ExamRoom> getExamRoomsByBlock(@PathVariable String block) {
        return examRoomService.getExamRoomsByBlock(block);
    }
    
    @GetMapping("/type/{roomType}")
    public List<ExamRoom> getExamRoomsByRoomType(@PathVariable String roomType) {
        return examRoomService.getExamRoomsByRoomType(roomType);
    }
    
    @GetMapping("/floor/{floor}")
    public List<ExamRoom> getExamRoomsByFloor(@PathVariable String floor) {
        return examRoomService.getExamRoomsByFloor(floor);
    }
    
    @GetMapping("/amenities/{amenity}")
    public List<ExamRoom> getExamRoomsWithAmenities(@PathVariable String amenity) {
        return examRoomService.getExamRoomsWithAmenities(amenity);
    }
    
    @GetMapping("/description/{keyword}")
    public List<ExamRoom> searchExamRoomsByDescriptionKeyword(@PathVariable String keyword) {
        return examRoomService.searchExamRoomsByDescriptionKeyword(keyword);
    }
    
//    @PostMapping("/reserve")
//    public ExamRoom reserveExamRoom(@RequestBody ExamRoom examRoom) {
//        // Implement reservation logic here
//        // This is a placeholder, you should implement the actual reservation logic
//        // and return the reserved exam room or appropriate response
//        return 
//    }
}
