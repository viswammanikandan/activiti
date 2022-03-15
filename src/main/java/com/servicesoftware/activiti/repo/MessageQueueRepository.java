package com.servicesoftware.activiti.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicesoftware.activiti.model.MessageQueue;

public interface MessageQueueRepository extends JpaRepository<MessageQueue, Long> {

	public MessageQueue findByMqName(String mqName);
	

}
