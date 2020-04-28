package com.springsecurity.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String login() {
		return "<h1>Login Page</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Admin Page</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>User Page</h1>";
	}

}
