package com.locationVoiture.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.locationVoiture.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	
}
