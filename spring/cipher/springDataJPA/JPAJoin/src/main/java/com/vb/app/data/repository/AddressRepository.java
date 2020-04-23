package com.vb.app.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.vb.app.data.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
