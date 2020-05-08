package com.perficient.Spring_POC.rest.controller;

import com.perficient.Spring_POC.data.entity.Student;
import com.perficient.Spring_POC.data.service.MyUserDetailsService;
import com.perficient.Spring_POC.data.service.StudentService;
import com.perficient.Spring_POC.exception.CustomEntityNotFoundException;
import com.perficient.Spring_POC.model.AuthenticationRequest;
import com.perficient.Spring_POC.model.AuthenticationResponse;
import com.perficient.Spring_POC.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest")
@Slf4j
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	/**
	 * Get
	 * 
	 */
	@RequestMapping("/admin/students/allStudents")
	public ResponseEntity<List<Student>> findAll() {
		List<Student> all = studentService.findAll();
		return ResponseEntity.ok(all);
	}

	@RequestMapping(method=RequestMethod.GET, value="/students/studentId/{studentId}")
	public ResponseEntity<Student> findById(@PathVariable Long studentId) {
		Student student = studentService.findById(studentId);
		return ResponseEntity.ok(student);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/students/firstName/{firstName}")
	public ResponseEntity<List<Student>> findByFirstname(@PathVariable("firstName") String firstName) {
		List<Student> list = studentService.findByFirstName(firstName);
		return ResponseEntity.ok(list);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/students/lastName/{lastName}")
	public ResponseEntity<List<Student>> findByLastName(@PathVariable ("lastName") String lastName) {
		List<Student> list = studentService.findByLastName(lastName);
		return ResponseEntity.ok(list);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/students/email/{email}")
	public ResponseEntity<Student> findByEmail(@PathVariable ("email") String email) {
		Student student = studentService.findByEmail(email);
		return ResponseEntity.ok(student);
	}
	/**
	 * Post
	 * @param student
	 * @return
	 */
	
	@RequestMapping(method=RequestMethod.POST, value="/admin/students/post/student")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		Student student1 = studentService.save(student);
		return ResponseEntity.ok(student1);
	}

	/**
	 * Delete
	 * @param studentId
	 * @return
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/admin/students/studentId/{studentId}")
	public ResponseEntity deleteById(@PathVariable int studentId) {
		studentService.deleteById(studentId);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/students/firstName/{firstName}")
	public ResponseEntity deleteByFirstName(@PathVariable ("firstName") String firstName) {
		studentService.deleteByFirstName(firstName);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Put
	 * @param student
	 * @param studentId
	 * @return
	 */
	
	@RequestMapping(method=RequestMethod.PUT, value="/admin/students/studentId/{studentId}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable long studentId) {
		Student student1 = studentService.update(student, studentId);
		return ResponseEntity.ok(student);
		
	}
	
	/**
	 * JWT Token
	 */

	@RequestMapping(method = RequestMethod.POST, value="/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws CustomEntityNotFoundException {
		try {
			authenticationManager.authenticate( 
						new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
		}
		catch(BadCredentialsException e) {
			throw new RuntimeException("Incorrect User details");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}