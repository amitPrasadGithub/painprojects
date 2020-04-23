package com.infotech.people.management.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.people.management.app.entities.Person;
import com.infotech.people.management.app.services.PeopleManagementService;

@SpringBootApplication
public class CustomQueriesWithQueryMethodsApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;

	public static void main(String[] args) {
		SpringApplication.run(CustomQueriesWithQueryMethodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Person person = new Person("Cheryl", "Parker", "cheryl.parker@riverdale.com", new Date());
//		peopleManagementService.createPerson(person);

		
//		singleParameter();
		multipleParameter();
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
	

}
