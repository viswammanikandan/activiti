package com.servicesoftware.activiti.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicesoftware.activiti.repo.MessageQueueRepository;

@Service
public class ApprovalCheckService implements JavaDelegate {

	@Autowired
	private MessageQueueRepository messageQueueRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		System.out.println("Task 2 Approval check executed successfully.");

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		execution.setVariable("approved", true);
		/*
		 * List<MessageQueue> mlist = messageQueueRepository.findAll();
		 * 
		 * System.out.println("AC getProcessInstanceId:"+execution.getProcessInstanceId(
		 * )); System.out.println("AC getEventName:"+execution.getEventName());
		 * System.out.println("AC getId:"+execution.getId());
		 * System.out.println("AC getProcessBusinessKey:"+execution.
		 * getProcessBusinessKey());
		 * System.out.println("AC getProcessDefinitionId:"+execution.
		 * getProcessDefinitionId());
		 * System.out.println("AC getParentId:"+execution.getParentId());
		 * 
		 * mlist.forEach(mqueue -> {
		 * if(mqueue.getProcessId().equals(execution.getProcessInstanceId()) &&
		 * mqueue.getApproved().equals("yes")) { execution.setVariable("approved",
		 * true); } else { execution.setVariable("approved", false); } });
		 */

	}
}
