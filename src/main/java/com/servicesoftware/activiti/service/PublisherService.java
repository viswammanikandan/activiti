package com.servicesoftware.activiti.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicesoftware.activiti.config.MessagingConfig;

@Service
public class PublisherService {
	@Autowired
    private RabbitTemplate template;
	
	public void myService() {

		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, "Approved");
		System.out.println("Task 3 message pushed to MQ.");

	}
}