package com.employee.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);

	boolean existsByUsername(String username);
}
