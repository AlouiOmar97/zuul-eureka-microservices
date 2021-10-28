package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

	
	@Autowired
	private TaskRepository taskRepository;
	
	
	//Ajouter un task
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	
	//Mettre a jour les informations d'une task
	public Task updateTask(int id, Task newTask) {
		if(taskRepository.findById(id).isPresent()) {
			Task existingTask = taskRepository.findById(id).get();
			existingTask.setUserId(newTask.getUserId());
			existingTask.setTask(newTask.getTask());
			
			return taskRepository.save(existingTask);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer une task
	public String deleteTask(int id) {
		if(taskRepository.findById(id).isPresent()) {
			taskRepository.deleteById(id);
			return "Task avec l'id " + id + " a ete supprime";
		}
		else {
			return "Task avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les tasks
	public  List<Task> GetTasks() {
		return taskRepository.findAll();
	}
	
	//Chercher une task
	public Task findTask(int id) {
		if(taskRepository.findById(id).isPresent()) {
			Task existingTask= taskRepository.findById(id).get();
			return existingTask;
		}
		else {
			return null;
		}
	}
	
	
	
	
}
