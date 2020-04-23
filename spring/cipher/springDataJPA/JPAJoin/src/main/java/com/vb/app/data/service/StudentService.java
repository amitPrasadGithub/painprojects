package com.vb.app.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vb.app.data.entity.Student;
import com.vb.app.data.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> itr = studentRepository.findAll();
		itr.forEach(list::add);
		return list;
	}
	
	public void postStudent(Student student) {
		studentRepository.save(student);
	}
}
