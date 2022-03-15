package com.servicesoftware.activiti.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servicesoftware.activiti.config.MessagingConfig;
import com.servicesoftware.activiti.model.MessageQueue;
import com.servicesoftware.activiti.repo.MessageQueueRepository;

@Component
public class Consumer {
	
	@Autowired
    private MessageQueueRepository messageQueueRepository;
	
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(MessageQueue messageQueue) {
		
		System.out.println("Consumer task: Message recieved from queue : " + messageQueue);
		messageQueueRepository.save(messageQueue);
	}
}
