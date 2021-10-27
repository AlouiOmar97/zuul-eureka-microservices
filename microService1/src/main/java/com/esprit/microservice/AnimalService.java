package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalService {

	
	@Autowired
	private AnimalRepository animalRepository;
	
	
	//Ajouter un animal
	public Animal addAnimal(Animal animal) {
		return animalRepository.save(animal);
	}
	
	
	//Mettre a jour les informations d'un animal
	public Animal updateAnimal(int id, Animal newAnimal) {
		if(animalRepository.findById(id).isPresent()) {
			Animal existingAnimal = animalRepository.findById(id).get();
			existingAnimal.setNom(newAnimal.getNom());
			existingAnimal.setGenre(newAnimal.getGenre());
			existingAnimal.setCouleur(newAnimal.getCouleur());
				existingAnimal.setPrix(newAnimal.getPrix());
			return animalRepository.save(existingAnimal);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer un animal
	public String deleteAnimal(int id) {
		if(animalRepository.findById(id).isPresent()) {
			animalRepository.deleteById(id);
			return "Le animal avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le animal avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les animals
	public  List<Animal> GetAnimals() {
		return animalRepository.findAll();
	}
	
	//Methode additionnelle (Pas dans l'atelier)
	//Chercher un animal
	public Animal findAnimal(int id) {
		if(animalRepository.findById(id).isPresent()) {
			Animal existingAnimal = animalRepository.findById(id).get();
			return existingAnimal;
		}
		else {
			return null;
		}
	}
	
	
	
	
}
