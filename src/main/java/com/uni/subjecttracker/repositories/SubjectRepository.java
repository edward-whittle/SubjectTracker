package com.uni.subjecttracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uni.subjecttracker.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	
}