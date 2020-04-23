package com.spring.jpa.customqueries.byMethodNames;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Client {

	@Autowired
	private PeopleManagementService peopleManagementService;

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
