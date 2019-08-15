package com.uni.subjecttracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity for Subject Input to MySQL DB
 */
@Entity
@Table(name = "Subjects")
public class Subject{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectID;
	
    @NotBlank
    @Size(min=3, max = 255)
    private String subjectName;
    
    private Integer studentID;
    
    private Integer credits;
    
    public Subject() {}
    
    //Getters and Setters
    public Subject(String inputSubjectName, Integer inputStudentID, Integer inputCredits) {
    	this.subjectName = inputSubjectName;
    	this.studentID = inputStudentID;
    	this.credits = inputCredits;
    }
    
    public void setSubjectID(Integer inputSubjectID) {
    	this.subjectID = inputSubjectID;
    }
    
    public Integer getSubjectID() {
    	return this.subjectID;
    }
    
    public void setSubjectName(String inputSubjectName) {
    	this.subjectName = inputSubjectName;
    }
    
    public String getSubjectName() {
    	return this.subjectName;
    }
    
    public void setStudentID(Integer inputStudentID) {
    	this.studentID = inputStudentID;
    }
    
    public Integer getStudentId() {
    	return this.studentID;
    }
    
    public void setCredits(Integer inputCredits) {
    	this.credits = inputCredits;
    }
    
    public Integer getCredits() {
    	return this.credits;
    }
}