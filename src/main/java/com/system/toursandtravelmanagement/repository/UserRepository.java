package com.system.toursandtravelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.toursandtravelmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String emailId);
}
