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

	public void createPerson(Person person) {
		peopleManagementDAO.save(person);
	}

	public void createPersons(List<Person> list) {
		peopleManagementDAO.saveAll(list);
	}

}
