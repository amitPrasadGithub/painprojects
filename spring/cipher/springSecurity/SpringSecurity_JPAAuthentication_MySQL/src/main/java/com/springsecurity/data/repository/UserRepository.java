package com.springsecurity.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
