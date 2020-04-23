package com.javatechie.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.jpa.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
