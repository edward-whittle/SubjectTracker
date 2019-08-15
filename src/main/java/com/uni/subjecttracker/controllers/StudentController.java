package com.uni.subjecttracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uni.subjecttracker.exceptions.ResourceNotFoundException;
import com.uni.subjecttracker.models.Student;
import com.uni.subjecttracker.repositories.StudentRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class StudentController
{
	//Connection for Repository
	@Autowired
	StudentRepository studentRepository;
	
	/**
	 * Returns all students in the database
	 * @return List<Student>
	 */
	@GetMapping("/students")
    public List<Student> getAllUsers() 
	{
        return studentRepository.findAll();
    }
	
	/**
	 * Returns the details of an individual Student from their ID
	 * @param studentID
	 * @return Student
	 */
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable(value = "id") Integer studentID) 
    {
        return studentRepository.findById(studentID).orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentID));
    }
    
    /**
     * Creates a new student in the MySQL DB
     * @param student
     * @return Student
     */
	@PostMapping("/student")
    public Student createStudent(@Valid @RequestBody Student student) 
	{	
        return studentRepository.save(student);
    }
}