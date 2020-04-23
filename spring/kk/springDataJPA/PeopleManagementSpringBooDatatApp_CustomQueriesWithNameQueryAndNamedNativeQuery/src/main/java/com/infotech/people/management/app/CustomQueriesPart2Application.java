package com.infotech.people.management.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.people.management.app.entities.Person;
import com.infotech.people.management.app.services.PeopleManagementService;

@SpringBootApplication
public class CustomQueriesPart2Application implements CommandLineRunner {
	
	@Autowired
	private PeopleManagementService peopleManagementService;
	@Override
	public void run(String... args) throws Exception {
//		singleParameter();
//		multipleParameter();
//		namedQuery();
//		namedNativeQuery();
		queryAnnotation();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomQueriesPart2Application.class, args);
	}

	public void singleParameter() {
		List<Person> firstNameList = peopleManagementService.findByFirstName("Jason");
		firstNameList.forEach(System.out::println);
		
		List<Person> lastNameList = peopleManagementService.findByLastName("Parker");
		lastNameList.forEach(System.out::println);
		
		List<Person> emailList = peopleManagementService.findByEmail("archie.andrews@gmail.com");
		emailList.forEach(System.out::println);
	}
	public void multipleParameter() {
		List<Person> firstNameLastNameList = peopleManagementService.findByFirstNameAndLastName("Jason", "Parker");
		firstNameLastNameList.forEach(System.out::println);
		
		
		List<Person> firstNameLastNameEmail = peopleManagementService.findByFirstNameAndLastNameAndEmail("Cheryl", "Parker", "cheryl.parker@riverdale.com");
		firstNameLastNameEmail.forEach(System.out::println);
	}
	public void namedQuery() {
		List<Person> firstName = peopleManagementService.findByLastName("Parker");
		firstName.forEach(System.out::println);
		
		List<Person> lastName = peopleManagementService.findByFirstName("Archie");
		lastName.forEach(System.out::println);
	}

	public void namedNativeQuery() {
		List<Person> email = peopleManagementService.findByEmail("cheryl.parker@riverdale.com");
		email.forEach(System.out::println);
	}
	public void queryAnnotation() {
		List<Person> email = peopleManagementService.findByEmail("cheryl.parker@riverdale.com");
		email.forEach(System.out::println);
	}
}
