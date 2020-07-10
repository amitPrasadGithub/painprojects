package com.vb.RESTExceptionHandler.service.impl;

import org.springframework.stereotype.Service;

import com.vb.RESTExceptionHandler.exception.NoStudentFoundException;
import com.vb.RESTExceptionHandler.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public String fingStudentById(Integer id) {
		String name = "Zain";
		if(id == 1) return name;
		else throw new NoStudentFoundException("No Student found for id :: "+id);
	}
	
}
