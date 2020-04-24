package com.spring.jpa.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.jpa.app.entities.Address;

public interface AddressDAO extends CrudRepository<Address, Integer> {

}
