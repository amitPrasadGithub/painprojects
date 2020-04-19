package com.infotech.people.management.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.infotech.people.management.app.entities.Person;

public interface PeopleManagementDAO extends CrudRepository<Person, Integer> {

}
