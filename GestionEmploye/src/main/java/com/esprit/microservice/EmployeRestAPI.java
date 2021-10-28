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
@RequestMapping(value = "/api/employes")
public class EmployeRestAPI {
	
	private String title = "Hello from employe microsevices";
	
	@Autowired
	private EmployeService employeService;
	
	//http://localhost:0/hello
	//Resultat -> Message: Hello from employe microsevices
	//Execution URL: http://localhost:0/api/employes/hello
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	
	//Configuration de la methode POST
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe){
		return new ResponseEntity<>(employeService.addEmploye(employe), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:0/api/employes/1
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employe> updateEmploye(@PathVariable(value = "id") int id,
			@RequestBody Employe employe){
		return new ResponseEntity<>(employeService.updateEmploye(id, employe), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:0/api/employes/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employe> deleteEmploye(@PathVariable(value = "id") int id){
		employeService.deleteEmploye(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
		//Execution URL:http://localhost:0/api/employes/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Employe> getAllEmployes(){
		return employeService.GetEmployes();
	}
	
	
	//Execution URL: http://localhost:0/api/employes
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employe> searchEmploye(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(employeService.findEmploye(id) , HttpStatus.OK);
	}
	
	
	

}
