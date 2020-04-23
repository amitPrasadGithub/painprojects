package com.spring.jpa.customqueries.byMethodNames;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PeopleManagementDAO extends CrudRepository<Person, Integer> {
	List<Person> findByFirstName(String firstName);
	List<Person> findByLastName(String lastName);
	List<Person> findByEmail(String email);
	
	
	List<Person> findByFirstNameAndLastName(String firstName, String lastName);
	List<Person> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
}
