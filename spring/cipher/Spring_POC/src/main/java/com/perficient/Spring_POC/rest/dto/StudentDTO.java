package com.perficient.Spring_POC.rest.dto;

import com.perficient.Spring_POC.data.entity.Student;

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
}
