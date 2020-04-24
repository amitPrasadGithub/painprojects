package com.example.webservices;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student>getAllStudents() {
			return studentService.getAllStudents();	
	}
	@RequestMapping("/students/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(Integer.parseInt(id));
	}
	@RequestMapping(method=RequestMethod.POST, value="/students")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/students/{id}")
	public void modifyStudent(@RequestBody Student student, @PathVariable String id) {
		studentService.modifyStudent(student, Integer.parseInt(id));
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/students/{id}")
	public void deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(Integer.parseInt(id));
	}
}
