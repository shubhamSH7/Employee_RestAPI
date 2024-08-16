package com.employee.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	List<Employee> findByName(String name);

	List<Employee> findByNameContainsAllIgnoreCase(String name);

	List<Employee> findByEmail(String email);

	List<Employee> findBySalary(Double salary);

	List<Employee> findByDepartment(String department);

	boolean existsByName(String name);

}
