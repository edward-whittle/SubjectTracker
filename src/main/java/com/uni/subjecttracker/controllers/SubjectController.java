package com.uni.subjecttracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uni.subjecttracker.exceptions.ResourceNotFoundException;
import com.uni.subjecttracker.models.Subject;
import com.uni.subjecttracker.repositories.SubjectRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class SubjectController
{
	//Connection for Repository
	@Autowired
	SubjectRepository subjectRepository;
	
	/**
	 * Returns all of the entries in the Subject MySQL DB
	 * @return List<Student>
	 */
	@GetMapping("/subjects")
    public List<Subject> getAllUsers() 
	{
        return subjectRepository.findAll();
    }
	
	/**
	 * Returns the details of an individual Student from their ID
	 * @param subjectID
	 * @return Subject
	 */
    @GetMapping("/subjects/{id}")
    public Subject getSubjectById(@PathVariable(value = "id") Integer subjectID) 
    {
        return subjectRepository.findById(subjectID).orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subjectID));
    }
    
    /**
     * Creates a new student in the MySQL DB
     * @param student
     * @return Student
     */
	@PostMapping("/subject")
    public Subject createSubject(@Valid @RequestBody Subject subject) 
	{	
        return subjectRepository.save(subject);
    }
	
    @DeleteMapping("/subject/delete")
    public ResponseEntity<?> deleteSubject(@RequestParam(value = "id") Integer subjectID) 
    {
        Subject subject = subjectRepository.findById(subjectID)
                .orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subjectID));

        subjectRepository.delete(subject); 

        return ResponseEntity.ok().build();
    }
}