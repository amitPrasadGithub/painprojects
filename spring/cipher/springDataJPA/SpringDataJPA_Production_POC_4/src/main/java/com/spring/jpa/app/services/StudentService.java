package com.spring.jpa.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.jpa.app.dao.StudentDAO;
import com.spring.jpa.app.entities.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;

	public Student findById(long id) {
		return studentDAO.findById(id).get();
	}
	public List<Student> findAllByIds(List<Long> list) {
		List<Student> m_list = new ArrayList<>();
		Iterable<Student> itr = studentDAO.findAllById(list);
		itr.forEach(m_list::add);
		return m_list;
	}
	public List<Student> findAll() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> itr = studentDAO.findAll();
		itr.forEach(list::add);
		return list;
	}
	public ResponseEntity<Student> save(Student student) {
		studentDAO.save(student);
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
	public ResponseEntity<Student> saveAll(List<Student> list) {
		studentDAO.saveAll(list);
		return new ResponseEntity<Student>(HttpStatus.CREATED);
	}
	public ResponseEntity<Void> deleteById(long id) {
		studentDAO.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	public void deleteAll(List<Student> list) {
		studentDAO.deleteAll(list);
	}
	public ResponseEntity<Student> update(Student student, long id) {
		Iterable<Student> list = studentDAO.findAll();
		for(Student s:list) {
			if(s.getStudentId() == id) {
				student.setStudentId(id);
				studentDAO.save(student);
				return new ResponseEntity(HttpStatus.ACCEPTED);
			}
		}
		return null;
	}
}
