package com.servicesoftware.activiti.service;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicesoftware.activiti.config.MessagingConfig;
import com.servicesoftware.activiti.model.MessageQueue;
import com.servicesoftware.activiti.repo.MessageQueueRepository;

@Service
public class PublisherService {
	@Autowired
    private RabbitTemplate template;
	
	@Autowired
    private MessageQueueRepository messageQueueRepository;
	
	public void myService() {
		MessageQueue msgQueue = new MessageQueue();
		msgQueue.setApproved("yes");
		template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, msgQueue);
		System.out.println("Task 1 message pushed to MQ.");

	}
	
	public void failNotification() {
		System.out.println("Decision Task3: Approval process has been rejected, please contact Adminstrator");
	}
	
	public void successNotification() {
		System.out.println("Decision Task3: Your application has been approved");
	}
	
	public void myApproval(DelegateExecution execution) {
		
		try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);} 
		
		List<MessageQueue> mlist = messageQueueRepository.findAll();
		
		System.out.println("AC getProcessInstanceId:"+execution.getProcessInstanceId());
		System.out.println("AC getEventName:"+execution.getEventName());
		System.out.println("AC getId:"+execution.getId());
		System.out.println("AC getProcessBusinessKey:"+execution.getProcessBusinessKey());
		System.out.println("AC getProcessDefinitionId:"+execution.getProcessDefinitionId());
		System.out.println("AC getParentId:"+execution.getParentId());
		System.out.println("mlist..."+mlist);
		mlist.forEach(mqueue -> {
			if(mqueue.getProcessId().equals(execution.getProcessInstanceId())
					&& mqueue.getApproved().equals("yes")) {
				execution.setVariable("approved", true);
			}
			else {
				execution.setVariable("approved", false);
			}
		});
		System.out.println("Task 1 message pushed to MQ.");

	}
}