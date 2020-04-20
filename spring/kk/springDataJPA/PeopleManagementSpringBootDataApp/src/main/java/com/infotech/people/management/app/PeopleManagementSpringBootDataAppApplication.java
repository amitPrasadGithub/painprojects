package com.infotech.people.management.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.people.management.app.entities.Person;
import com.infotech.people.management.app.services.PeopleManagementService;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner {
	
	@Autowired
	private PeopleManagementService peopleManagementService;

	public void run(String... args) throws Exception {
		/*
		 * Add paramters from BeforeApplicationStart
		 */
		
//		createPerson();
//		createPersons(persons);
//		deletePersonById(6);
//		updateEmail(4, "parker11.jason@riverdale.com");
		
	}
	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}
	public void createPerson() {
		Person person = new Person("Jason", "Parker", "jason.parker@gmail.com", new Date());
		peopleManagementService.createPerson(person);
	}
	public void createPersons(List<Person> list) {
		peopleManagementService.createPersons(list);
	}
	private void getPersonByIds(List<Integer> list) {
		Iterable<Person> person_list = peopleManagementService.getPersonByIds(list);
		person_list.forEach(System.out::println);
	}
	private void deletePerson(Person person) {
		peopleManagementService.deletePerson(person);
	}
	private void deletePersonById(int id) {
		peopleManagementService.deletePersonById(id);
	}
	
	public void updateEmail(int id, String email) {
		Person person = peopleManagementService.getPersonById(id);
		if(person.getId() == id) 
			person.setEmail(email);
		peopleManagementService.createPerson(person);
	}

}
