package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.exception.UserExistsException;
import com.employee.model.UserRepo;
import com.employee.model.Users;

@Service
public class Userservice {
	@Autowired
	UserRepo repo;

	@Autowired
	PasswordEncoder encoder;

	public void registerUser(Users user) {
		if (repo.existsByUsername(user.getUsername())) {
			throw new UserExistsException("User Already Exists");
		}
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
	}
}
