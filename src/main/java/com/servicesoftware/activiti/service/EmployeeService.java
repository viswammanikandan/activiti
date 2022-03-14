package com.servicesoftware.activiti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicesoftware.activiti.model.Employee;
import com.servicesoftware.activiti.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// create the list of Employees into the database who perform the task
	public void createEmployee() {

		if (employeeRepository.findAll().size() == 0) {

			employeeRepository.save(new Employee("Mani", "Architect"));
			employeeRepository.save(new Employee("Almas", "Technical Lead"));
		}
	}
}
