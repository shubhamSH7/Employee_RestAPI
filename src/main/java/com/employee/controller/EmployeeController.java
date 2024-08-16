package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl serviceImpl;

	@GetMapping(path = "employees")
	public ResponseEntity<List<Employee>> GetAllEmployee() {

		return new ResponseEntity<List<Employee>>(serviceImpl.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping(path = "employee/{id}")
	public ResponseEntity<Employee> GetById(@PathVariable Long id) {
		Employee e = serviceImpl.getEmployeeById(id);
		return new ResponseEntity<Employee>(e, HttpStatus.ACCEPTED);
	}

	@PostMapping(path = "/")
	public ResponseEntity<Employee> CreateEmployee(@Valid @RequestBody Employee newEmployee) {
		serviceImpl.createEmployee(newEmployee);
		return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
	}

	@PutMapping(path = "update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee UpdateEmployee) {
		serviceImpl.updateEmployee(id, UpdateEmployee);
		return new ResponseEntity<Employee>(UpdateEmployee, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "delete/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable Long id) {
		serviceImpl.deleteEmployee(id);
		return new ResponseEntity<String>("Employee ID " + id + "Deleted", HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "employees/{name}")
	public ResponseEntity<List<Employee>> byName(@PathVariable String name) {
		List<Employee> byname = serviceImpl.findByName(name);

		return new ResponseEntity<List<Employee>>(byname, HttpStatus.ACCEPTED);
	}

	@GetMapping(path = "employees/{department}")
	public ResponseEntity<List<Employee>> byDepartment(@PathVariable String department) {
		List<Employee> byDept = serviceImpl.findBydepartment(department);

		return new ResponseEntity<List<Employee>>(byDept, HttpStatus.ACCEPTED);
	}

}
