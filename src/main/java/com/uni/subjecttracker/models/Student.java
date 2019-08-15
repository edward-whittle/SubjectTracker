package com.uni.subjecttracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity for Student Input to MySQL DB
 */
@Entity
@Table(name = "Students")
public class Student{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentID;
	
    @NotBlank
    @Size(min=3, max = 255)
    private String studentName;
    
    public Student() {}
    
    //Getters and Setters
    public Student(String inputStudentName) {
    	this.studentName = inputStudentName;
    }
    
    public void setStudentName(String inputStudentName) {
    	this.studentName = inputStudentName;
    }
    
    public String getStudentName() {
    	return this.studentName;
    }
}