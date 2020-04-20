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
		List<Person> persons = new ArrayList<Person>(
					Arrays.asList(
								new Person("Betty", "Cooper", "betty.cooper@gmail.com", new Date()),
								new Person("Archie", "Andrews", "archie.andrews@gmail.com", new Date())
							)
				);
//		createPerson();
//		createPersons(persons);

		List<Integer> list = new ArrayList<> (
					Arrays.asList(4, 5, 6)
				);
		getPersonByIds(list);
		
//		deletePersonById(personId);
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
		System.out.print("\n\n\n ###"+person_list+"### \n\n\n");

		person_list.forEach(System.out::println);
	}
}
