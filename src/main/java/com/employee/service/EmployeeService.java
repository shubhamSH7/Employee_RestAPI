package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Employee getEmployeeById(Long id);

	public Employee createEmployee(Employee employee);

	public Employee updateEmployee(Long id, Employee employee);

	public String deleteEmployee(Long id);

	public List<Employee> findByName(String name);

	public List<Employee> findBydepartment(String department);
}
