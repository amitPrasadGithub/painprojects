package com.vb.RESTExceptionHandler.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.vb.RESTExceptionHandler.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/students")
	public String getAllStudents(Model model) {
		List<String> names = Arrays.asList("amit", "sumit", "shubham");
		model.addAttribute("names", names);
		String str = null;
		str.length();
		return "allStudents";
	}
	
	@GetMapping(value = "/students/studentId/{id}")
	public String findById(@PathVariable("id") String id, Model model) {
		String name = studentService.fingStudentById(Integer.valueOf(id));
		model.addAttribute("name", name);
		return "student";
	}
}
