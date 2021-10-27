package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogService {

	
	@Autowired
	private BlogRepository blogRepository;
	
	
	//Ajouter un blog
	public Blog addBlog(Blog blog) {
		return blogRepository.save(blog);
	}
	
	
	//Mettre a jour les informations d'un blog
	public Blog updateBlog(int id, Blog newBlog) {
		if(blogRepository.findById(id).isPresent()) {
			Blog existingBlog = blogRepository.findById(id).get();
			existingBlog.setTitre(newBlog.getTitre());
			existingBlog.setTextB(newBlog.getTextB());
			existingBlog.setAuteur(newBlog.getAuteur());
			
			return blogRepository.save(existingBlog);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer un blog
	public String deleteBlog(int id) {
		if(blogRepository.findById(id).isPresent()) {
			blogRepository.deleteById(id);
			return "Le blog avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le blog avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les blogs
	public  List<Blog> GetBlogs() {
		return blogRepository.findAll();
	}
	
	//Methode additionnelle (Pas dans l'atelier)
	//Chercher un blog
	public Blog findBlog(int id) {
		if(blogRepository.findById(id).isPresent()) {
			Blog existingBlog = blogRepository.findById(id).get();
			return existingBlog;
		}
		else {
			return null;
		}
	}
	
	
	
	
}
