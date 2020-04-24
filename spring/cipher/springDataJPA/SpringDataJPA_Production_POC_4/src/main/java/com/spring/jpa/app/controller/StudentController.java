package com.spring.jpa.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.app.dao.AddressDAO;
import com.spring.jpa.app.dao.StudentDAO;
import com.spring.jpa.app.dto.StudentDTO;
import com.spring.jpa.app.entities.Student;
import com.spring.jpa.app.services.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	@RequestMapping(method=RequestMethod.GET, value="/students/{id}")
	public Student findById(@PathVariable int id) {
		return studentService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/students")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/students/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return studentService.deleteById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/students/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable int id) {
		return studentService.update(student, id);
		
	}

	
	/*
	 * 
	 * Join
	 */
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@RequestMapping(method=RequestMethod.POST, value="/rest/postStudents")
	public Student saveStudent(@RequestBody StudentDTO request) {
		return studentDAO.save(request.getStudent());
	}
	@RequestMapping(method=RequestMethod.GET, value="/rest/getStudents")
	public List<Student> findAllStudents() {
		List<Student> list = new ArrayList<>();
		
		Iterable<Student> itr = studentDAO.findAll();
		itr.forEach(list::add);
		return list;
	}
}
