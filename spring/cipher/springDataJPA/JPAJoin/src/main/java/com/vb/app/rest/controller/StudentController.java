package com.vb.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vb.app.data.entity.Student;
import com.vb.app.data.repository.AddressRepository;
import com.vb.app.data.repository.StudentRepository;
import com.vb.app.data.service.StudentService;
import com.vb.app.rest.dto.DTO;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(method = RequestMethod.GET, value="/rest/getStudents")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/rest/postStudents")
	public void postStudent(@RequestBody DTO dto) {
		studentService.postStudent(dto.getStudent());
	}
}
