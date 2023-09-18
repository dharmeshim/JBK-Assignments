package com.dpr.examiner.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dpr.examiner.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
    // You can define custom query methods here if needed
}
