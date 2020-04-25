package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Hi there";
	}
	
	@GetMapping("/")
	public String all() {
		return "Welcome";
	}
	
	@GetMapping("/user")
	public String user() {
		return "User";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

}
