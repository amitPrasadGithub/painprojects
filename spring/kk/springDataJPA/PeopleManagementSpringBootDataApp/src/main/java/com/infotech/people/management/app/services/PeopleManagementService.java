package com.infotech.people.management.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.people.management.app.dao.PeopleManagementDAO;
import com.infotech.people.management.app.entities.Person;

@Service
public class PeopleManagementService {

	@Autowired
	private PeopleManagementDAO peopleManagementDAO;

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

}
