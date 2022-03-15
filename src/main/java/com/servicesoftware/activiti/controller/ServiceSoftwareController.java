package com.servicesoftware.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicesoftware.activiti.service.ProcessService;

@RestController
@RequestMapping("activiti")
public class ServiceSoftwareController {

	@Autowired
	private ProcessService processService;

	/*
	 * Method will start the Activiti process engine and set employee to perform
	 * the task
	 */
	@RequestMapping(value = "/process")
	public String startProcessInstance(@RequestParam String assignee) {
		return processService.startTheProcess(assignee);
	}
	
	@RequestMapping(value = "/approvalProcess")
	public String startApprovalProcessInstance() {
		return processService.startTheApprovalProcess();
	}
}
