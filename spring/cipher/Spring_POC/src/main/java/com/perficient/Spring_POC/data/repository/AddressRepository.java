package com.perficient.Spring_POC.data.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perficient.Spring_POC.data.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	

}
