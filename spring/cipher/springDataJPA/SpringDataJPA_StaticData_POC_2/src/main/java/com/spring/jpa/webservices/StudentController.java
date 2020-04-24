package com.spring.jpa.webservices;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentService student_service;
	
	@RequestMapping("/students")
	public List<Student> getAllStudents() {
		return student_service.getAllStudents();
	}
	
	@RequestMapping("students/{id}")
	public Student getStudentById(@PathVariable String id) {
		return student_service.getStudentById(Integer.parseInt(id));
	}
	@RequestMapping(method=RequestMethod.PUT, value="students/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable String id) {
		student_service.updateStudent(student, Integer.parseInt(id));
	}
	@RequestMapping(method=RequestMethod.POST, value="students/")
	public void insertStudent(@RequestBody Student student) {
		student_service.insertStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="students/{id}")
	public void deleteStudentById(@PathVariable String id) {
		student_service.deleteStudentById(Integer.parseInt(id));
	}
}
