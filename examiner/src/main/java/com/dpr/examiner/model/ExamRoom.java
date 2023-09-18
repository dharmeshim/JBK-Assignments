package com.dpr.examiner.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExamRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int examRoomId;
    private String roomNumber;
    private int seatingCapacity;
    private boolean isAvailable; // Indicates whether the exam room is available for scheduling.
    private String address; // The address of the exam room.
    private String block; // The block or building where the exam room is located.
    private LocalDate dateOfAvailable; // The date when the exam room becomes available.
    private String amenities; // List of amenities available in the exam room (e.g., projector, whiteboard).
    private String roomType; // Type of room (e.g., lecture hall, classroom, lab).
    private String floor; // Floor or level of the exam room in the building.
    private String description; // Additional description or notes about the exam room.

    // Getters and setters for the fields

    public int getExamRoomId() {
        return examRoomId;
    }

    public void setExamRoomId(int examRoomId) {
        this.examRoomId = examRoomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public LocalDate getDateOfAvailable() {
        return dateOfAvailable;
    }

    public void setDateOfAvailable(LocalDate dateOfAvailable) {
        this.dateOfAvailable = dateOfAvailable;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
