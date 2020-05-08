package com.perficient.Spring_POC.data.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perficient.Spring_POC.data.entity.Student;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public Student findByEmail(String email);
	
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByLastName(String lastName);

	public void deleteByFirstName(String firstName);
	public void deleteByLastName(String lastName);
	public void deleteByEmail(String email);
	
	

}
