package com.uni.subjecttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uni.subjecttracker.models.Student;

/**
 * Persistence layer for Student entity
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}