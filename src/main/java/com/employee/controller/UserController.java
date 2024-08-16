package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Users;
import com.employee.service.Userservice;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	Userservice userservice;


	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody Users user) {
		userservice.registerUser(user);
		return new ResponseEntity<String>("Registered", HttpStatus.CREATED);
	}

	@GetMapping("/admin")
	public String admin() {
		return "this is admin only";
	}

}
