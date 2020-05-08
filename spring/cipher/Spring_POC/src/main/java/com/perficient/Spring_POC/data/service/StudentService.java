package com.perficient.Spring_POC.data.service;

import com.perficient.Spring_POC.data.entity.Student;
import com.perficient.Spring_POC.data.repositoty.StudentRepository;
import com.perficient.Spring_POC.exception.CustomEntityNotFoundException;
import com.perficient.Spring_POC.exception.UnmodifiableEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Get
	 * 
	 */
	public Student findById(long id) throws CustomEntityNotFoundException {
		Student student;
		try {
			student = studentRepository.findById(id).get();
		}catch(Exception e) { throw new CustomEntityNotFoundException("No record found for id : "+id); }
		return student;
	}
	public List<Student> findAllByIds(List<Long> list) {
		List<Student> m_list = new ArrayList<>();
		Iterable<Student> itr = studentRepository.findAllById(list);
		itr.forEach(m_list::add);
		return m_list;
	}
	public List<Student> findAll() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> itr = studentRepository.findAll();
		itr.forEach(list::add);
		log.info("Data "+list);
		return list;
	}

	public List<Student> findByFirstName(String firstName) {
		List<Student> m_list = new ArrayList<>();
		Iterable<Student> itr = studentRepository.findByFirstName(firstName);
		itr.forEach(m_list::add);
		if(m_list.size() == 0) throw new CustomEntityNotFoundException("No record found for : "+firstName);
		return m_list;
	}
	public List<Student> findByLastName(String lastName) {
		List<Student> m_list = new ArrayList<>();
		Iterable<Student> itr = studentRepository.findByLastName(lastName);
		itr.forEach(m_list::add);
		if(m_list.size() == 0) throw new CustomEntityNotFoundException("No record found for : "+lastName);
		return m_list;
	}

	public Student findByEmail(String email) {
		Student student;
		try {
			student = studentRepository.findByEmail(email);
			log.error("Data...["+student.toString());
		}catch(Exception e) {
			throw new CustomEntityNotFoundException("No record found for : "+email);
		}
		return student;
	}

	/**
	 * Post
	 * @param student
	 * @return
	 */
	public Student save(Student student) {
		Student newStudent;
		try {
			newStudent = studentRepository.save(student);
		}catch (Exception e) { throw new UnmodifiableEntityException("Failed to save the record"); }
		return newStudent;
	}
	public List<Student> saveAll(List<Student> list) {
		return studentRepository.saveAll(list);
	}

	/**
	 * Delete
	 * @param id
	 */
	public void deleteById(long id) {
		studentRepository.deleteById(id);
	}
	public void deleteAll(List<Student> list) {
		studentRepository.deleteAll(list);
	}
	public void deleteByFirstName(String firstName) {
		studentRepository.deleteByFirstName(firstName);
	}
	public void deleteByLastName(String lastName) {
		studentRepository.deleteByLastName(lastName);
	}
	public void deleteByEmail(String email) {
		studentRepository.deleteByEmail(email);
	}

	/**
	 * Put
	 * @param student
	 * @param id
	 * @return
	 */
	public Student update(Student student, long id) {
		Student newStudent = new Student();
		Iterable<Student> list = studentRepository.findAll();
		for(Student s:list) {
			if(s.getStudentId() == id) {
				student.setStudentId(id);
				try {
					newStudent =  studentRepository.save(student);
				}catch (Exception e) { throw new UnmodifiableEntityException("Failed to Update"); }
			}
		}
		return newStudent;
	}
}