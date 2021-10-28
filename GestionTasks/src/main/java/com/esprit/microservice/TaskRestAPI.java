package com.esprit.microservice;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/tasks")
public class TaskRestAPI {
	
	private String title = "Hello from employe-tasks microsevices";
	
	@Autowired
	private TaskService taskService;
	
	//http://localhost:0/hello
	//Resultat -> Message: Hello from employe-tasks microsevices
	//Execution URL: http://localhost:0/api/Tasks/hello
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	
	//Configuration de la methode POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:0/api/tasks/1
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") int id,
			@RequestBody Task task){
		return new ResponseEntity<>(taskService.updateTask(id, task), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:0/api/tasks/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> deleteTask(@PathVariable(value = "id") int id){
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
		//Execution URL:http://localhost:0/api/tasks/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Task> getAllTasks(){
		return taskService.GetTasks();
	}
	
	
	//Execution URL: http://localhost:0/api/tasks
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Task> searchTask(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(taskService.findTask(id) , HttpStatus.OK);
	}
	
	
	

}
