package com.servicesoftware.activiti.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicesoftware.activiti.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByName(String name);

}