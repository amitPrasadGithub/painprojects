package com.spring.jpa.webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository student_rep;

	private List<Student> list = new ArrayList<>(Arrays.asList(
			new Student(1, "Jason", "HR"),
			new Student(2, "Betty", "DB"),
			new Student(3, "Archi", "IT")
	));
	
	public List<Student> getAllStudents() {
//		return list;
		List<Student> list = new ArrayList<>();
		student_rep.findAll().forEach(list::add);
		
		return list;
	}
	public Student getStudentById(int id) {
/*
		for(Student student:list) {
			if(id == student.getStudentId()) 
				return student;
		}
		return null;
*/	
		
		return student_rep.findById(id).get();
	}
	public void updateStudent(Student student, int id) {
/*		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getStudentId() == id) {
				list.set(i, student);
			}
		}
*/
		student_rep.save(student);
	}
	public void insertStudent(Student student) {
//		list.add(student);	
		student_rep.save(student);
	}
	public void deleteStudentById(int id) {
/*	
		for(int i=0; i<list.size(); i++) {
			if(id == list.get(i).getStudentId()) {
				list.remove(i);
			}
		}
*/	
		student_rep.deleteById(id);
	}
}
