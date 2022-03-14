package com.servicesoftware.activiti.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.servicesoftware.activiti.config.MessagingConfig;

@Component
public class Consumer {

	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(String response) {
		System.out.println("Message recieved from queue : " + response);
	}
}
