package com.example.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestResource {
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hi";
	}
}
