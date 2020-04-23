package com.javatechie.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
