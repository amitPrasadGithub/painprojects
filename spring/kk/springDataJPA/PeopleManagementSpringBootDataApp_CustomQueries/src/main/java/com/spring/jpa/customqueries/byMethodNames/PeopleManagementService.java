package com.spring.jpa.customqueries.byMethodNames;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleManagementService {

	@Autowired
	private PeopleManagementDAO peopleManagementDAO;

	/*
	 * 
	 * CrudRepository Methods
	 */
	public Person getPersonById(int id) {
		return peopleManagementDAO.findById(id).get();
	}
	public void createPerson(Person person) {
		peopleManagementDAO.save(person);
	}
	public void createPersons(List<Person> list) {
		peopleManagementDAO.saveAll(list);
	}
	public Iterable<Person> getPersonByIds(List<Integer> list) {
		return peopleManagementDAO.findAllById(list);
	}
	public void deletePersonById(int id) {
		peopleManagementDAO.deleteById(id);
	}
	public void deletePersonByIds(List<Person> list) {
		peopleManagementDAO.deleteAll(list);
	}
	public void updatePerson(Person person, int id) {
		peopleManagementDAO.save(person);
	}
	public void deletePerson(Person person) {
		peopleManagementDAO.delete(person);
	}
	
	/*
	 * 
	 * Custom Methods/NamedMethods
	 * single parameter
	 */
	public List<Person> findByFirstName(String firstName) {
		return peopleManagementDAO.findByFirstName(firstName);
	}
	public List<Person> findByLastName(String lastName) {
		return peopleManagementDAO.findByLastName(lastName);
	}
	public List<Person> findByEmail(String email) {
		return peopleManagementDAO.findByEmail(email);
	}
	
	/*
	 * 
	 * Custom Methods / NamedMethods
	 * Multiple parameters
	 */
	public List<Person> findByFirstNameAndLastName(String firstName, String lastName) {
		return peopleManagementDAO.findByFirstNameAndLastName(firstName, lastName);
	}
	public List<Person> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email) {
		return peopleManagementDAO.findByFirstNameAndLastNameAndEmail(firstName, lastName, email);
	}
}

