package com.perficient.Spring_POC.data.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perficient.Spring_POC.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
