package com.servicesoftware.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.servicesoftware.activiti.service.EmployeeService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(final EmployeeService employeeService) {

		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				employeeService.createEmployee();
			}
		};
	}

}
