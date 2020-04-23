package com.infotech.people.management.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infotech.people.management.app.entities.Person;

public interface PeopleManagementDAO extends CrudRepository<Person, Integer> {
	List<Person> findByFirstName(String firstName);
	List<Person> findByLastName(String lastName);
	List<Person> findByEmail(String email);
	
	
	List<Person> findByFirstNameAndLastName(String firstName, String lastName);
	List<Person> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
}
