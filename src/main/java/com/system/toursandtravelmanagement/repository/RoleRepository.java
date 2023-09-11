package com.system.toursandtravelmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.system.toursandtravelmanagement.model.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

	Role findByRole(String name);
}
