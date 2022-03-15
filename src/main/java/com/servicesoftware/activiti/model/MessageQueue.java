package com.servicesoftware.activiti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MessageQueue {

	public MessageQueue() {
		// TODO Auto-generated constructor stub
	}

	public MessageQueue(Long id, String mqName, String approved, String processId, String taskId) {
		super();
		this.id = id;
		this.mqName = mqName;
		this.approved = approved;
		this.processId = processId;
		this.taskId = taskId;
	}

	@Id
	@GeneratedValue
	private Long id;
	private String mqName;
	private String approved;
	private String processId;
	private String taskId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMqName() {
		return mqName;
	}
	public void setMqName(String mqName) {
		this.mqName = mqName;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
}
