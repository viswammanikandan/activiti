package com.servicesoftware.activiti.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicesoftware.activiti.config.MessagingConfig;


@Service
public class ApprovalService implements JavaDelegate {
	
	@Override
	public void execute(DelegateExecution execution) {
		
		System.out.println("Task 2 Approval process executed successfully.");

	}
}
