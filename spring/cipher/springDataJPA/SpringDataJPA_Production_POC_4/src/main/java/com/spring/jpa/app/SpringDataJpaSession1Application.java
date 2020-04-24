package com.spring.jpa.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpa.app.entities.Student;
import com.spring.jpa.app.services.StudentService;

@SpringBootApplication
public class SpringDataJpaSession1Application { 
	
/*
	
	@Autowired
	private StudentService StudentService;
	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("Jason", "Parker", "jason.parker@gmail.com", new Date());
		StudentService.save(student);
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaSession1Application.class, args);
	}

}
