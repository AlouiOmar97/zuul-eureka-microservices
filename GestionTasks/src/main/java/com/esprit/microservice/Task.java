package com.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task implements Serializable{
	private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue
	private int id;
	private String userId, task;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public Task() {	}
	
	public Task(int id, String userId, String task) {
		super();
		this.id = id;
		this.userId = userId;
		this.task = task;
	}
	public Task(String userId, String task) {
		super();
		this.userId = userId;
		this.task = task;
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
