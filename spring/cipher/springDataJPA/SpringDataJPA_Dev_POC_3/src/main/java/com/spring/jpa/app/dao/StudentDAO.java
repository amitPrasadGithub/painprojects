package com.spring.jpa.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.jpa.app.entities.Student;

public interface StudentDAO extends CrudRepository<Student, Long> {
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByLastName(String lastName);
	/*
	 * 
	 * @Query
	 * first precedence among (NamedQuery, NamedNativeQuery)
	 * uses JPQL
	 */
	@Query("select s from Student s where s.email = ?1")
	public List<Student> findByEmail(String email);
	
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	public List<Student> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
	
}
