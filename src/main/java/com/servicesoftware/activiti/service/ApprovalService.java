package com.servicesoftware.activiti.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicesoftware.activiti.config.MessagingConfig;
import com.servicesoftware.activiti.model.MessageQueue;


@Service
public class ApprovalService implements JavaDelegate {
	@Autowired
    private RabbitTemplate template;
	@Override
	public void execute(DelegateExecution execution) {
		
		System.out.println("AS getProcessInstanceId:"+execution.getProcessInstanceId());
		System.out.println("AS getEventName:"+execution.getEventName());
		System.out.println("AS getId:"+execution.getId());
		System.out.println("AS getProcessBusinessKey:"+execution.getProcessBusinessKey());
		System.out.println("AS getProcessDefinitionId:"+execution.getProcessDefinitionId());
		System.out.println("AS getParentId:"+execution.getParentId());
		MessageQueue msgQueue = new MessageQueue();
		msgQueue.setApproved("yes");
		msgQueue.setMqName(execution.getEventName());
		msgQueue.setProcessId(execution.getProcessInstanceId());
		msgQueue.setTaskId(execution.getId());
			template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, msgQueue);
			System.out.println("Task 1 message pushed to MQ.");
		System.out.println("Task 2 Approval process executed successfully.");
		

	}
}
