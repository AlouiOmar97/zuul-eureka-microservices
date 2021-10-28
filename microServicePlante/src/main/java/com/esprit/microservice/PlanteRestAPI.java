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
@RequestMapping(value = "/api/plantes")
public class PlanteRestAPI {
	
	
	@Autowired
	private PlanteService planteService;
	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println("title");
		return "title";
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Plante> createPlante(@RequestBody Plante plante){
		return new ResponseEntity<>(planteService.addPlante(plante), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:8282/api/plantes/search
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Plante> updatePlante(@PathVariable(value = "id") int id,
			@RequestBody Plante plante){
		return new ResponseEntity<>(planteService.updatePlante(id, plante), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:8282/api/plantes/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Plante> deletePlante(@PathVariable(value = "id") int id){
		planteService.deletePlante(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode GET All
	//Execution URL: http://localhost:8282/api/plantes/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Plante> getAllPlantes(){
		return planteService.getPlantes();
	}
	
	
	//Execution URL: http://localhost:8282/api/plantes
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Plante> searchPlante(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(planteService.findPlante(id) , HttpStatus.OK);
	}
	
	
	

}
