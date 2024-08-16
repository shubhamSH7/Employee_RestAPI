package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeExistsException;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.model.EmployeeRepo;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepo Repo;

	public EmployeeServiceImpl(EmployeeRepo repo) {
		super();
		Repo = repo;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allemployee = Repo.findAll();
		if (allemployee.isEmpty()) {
			throw new EmployeeNotFoundException("Employees list is empty add new and try again");
		}
		return allemployee;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		if (!Repo.existsById(id)) {
			throw new EmployeeNotFoundException("Employee with ID" + id + " not found");
		}
		return Repo.findById(id).get();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		if (Repo.existsById(employee.getId())) {
			throw new EmployeeExistsException("Employee with Id " + employee.getId() + " exists");
		}
		Repo.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		if (!Repo.existsById(id)) {
			throw new EmployeeNotFoundException("Employee with id " + id + " not found");
		}
		Employee emptemp = Repo.findById(id).get();
		emptemp.setEmail(employee.getEmail());
		emptemp.setName(employee.getName());
		emptemp.setSalary(employee.getSalary());
		Repo.save(emptemp);

		return employee;
	}

	@Override
	public String deleteEmployee(Long id) {
		if (!Repo.existsById(id)) {
			throw new EmployeeNotFoundException("Employee with id: " + id + " not found");
		}
		Repo.deleteById(id);
		return "deleted";
	}

	@Override
	public List<Employee> findByName(String name) {
		List<Employee> byname = Repo.findByNameContainsAllIgnoreCase(name);
		if (byname.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with name : " + name + " not found");
		}
		return byname;
	}

	@Override
	public List<Employee> findBydepartment(String department) {
		List<Employee> bydept = Repo.findByDepartment(department);
		if (bydept.isEmpty()) {
			throw new EmployeeNotFoundException("No Employee in " + department + "found or deparment does not exist");
		}
		return bydept;

	}

}
