package com.vb.app.rest.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.vb.app.data.entity.Student;

public class DTO {

	private Student student;
	
	public DTO() {}

	public DTO(Student student) {
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
		return "DTO [student=" + student + "]";
	} 
}
