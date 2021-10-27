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
@RequestMapping(value = "/api/blogs")
public class BlogRestAPI {
	
	
	@Autowired
	private BlogService blogService;
	
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		return new ResponseEntity<>(blogService.addBlog(blog), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:8282/api/blogs/search
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Blog> updateBlog(@PathVariable(value = "id") int id,
			@RequestBody Blog blog){
		return new ResponseEntity<>(blogService.updateBlog(id, blog), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:8282/api/blogs/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Blog> deleteBlog(@PathVariable(value = "id") int id){
		blogService.deleteBlog(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode GET All
	//Execution URL: http://localhost:8282/api/blogs/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Blog> getAllBlogs(){
		return blogService.GetBlogs();
	}
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode de recherche GET specifique avec PathParam
	//il faut que les noms des methodes ici Blog Resst API) et celles dans BlogService n'aient pas le meme nom, sinon ca degere une erreue de mapping
	//Execution URL: http://localhost:8282/api/blogs
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Blog> searchBlog(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(blogService.findBlog(id) , HttpStatus.OK);
	}
	
	
	

}
