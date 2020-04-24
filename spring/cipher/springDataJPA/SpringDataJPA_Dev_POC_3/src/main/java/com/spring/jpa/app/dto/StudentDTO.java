package com.spring.jpa.app.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.jpa.app.entities.Student;

public class StudentDTO {
	
	private Student student;

	public StudentDTO() {} 
	
	public StudentDTO(Student student) {
		super();
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "FetchRequest [student=" + student + "]";
	}
	
	
}
