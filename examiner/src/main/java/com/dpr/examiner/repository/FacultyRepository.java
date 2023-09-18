package com.dpr.examiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dpr.examiner.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
