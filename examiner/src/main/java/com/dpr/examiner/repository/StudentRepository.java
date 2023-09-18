package com.dpr.examiner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpr.examiner.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
