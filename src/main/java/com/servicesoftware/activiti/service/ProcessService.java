package com.servicesoftware.activiti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicesoftware.activiti.model.Employee;
import com.servicesoftware.activiti.repo.EmployeeRepository;

@Service
public class ProcessService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	 
	// start the process and set employee as variable
	public String startTheProcess(String assignee) {

		Employee employee = employeeRepository.findByName(assignee);

		Map<String, Object> variables = new HashMap<>();
		variables.put("employee", employee);
		
		System.out.println("Process intiated successfully...");

		runtimeService.startProcessInstanceByKey("service-software", variables);
		
		List<Task> tasks = getTasks(assignee);
		
		System.out.println("Task 1 starts here..."+tasks.toString());
		
		return "All tasks completed successfully";
	}
	
		public String startTheApprovalProcess() {
			System.out.println("Process intiated successfully...");
			runtimeService.startProcessInstanceByKey("SerivceSoftwarezV2");
			
			return "All tasks completed successfully";
		}

	// fetch task assigned to employee
	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}

	// complete the task
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}
}
