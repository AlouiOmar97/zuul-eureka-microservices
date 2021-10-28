package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanteService {

	
	@Autowired
	private PlanteRepository planteRepository;
	
	
	
	public Plante addPlante(Plante plante) {
		return planteRepository.save(plante);
	}
	
	
	public Plante updatePlante(int id, Plante newPlante) {
		if(planteRepository.findById(id).isPresent()) {
			Plante existingPlante = planteRepository.findById(id).get();
			existingPlante.setNom(newPlante.getNom());
			existingPlante.setGenre(newPlante.getGenre());
			existingPlante.setCouleur(newPlante.getCouleur());
			existingPlante.setPrix(newPlante.getPrix());
			return planteRepository.save(existingPlante);
		}
		else {
			return null;
		}
	}
	
	
	
	public String deletePlante(int id) {
		if(planteRepository.findById(id).isPresent()) {
			planteRepository.deleteById(id);
			return "La plante avec l'id " + id + " a ete supprime";
		}
		else {
			return "La plante avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les Plantes
	public  List<Plante> getPlantes() {
		return planteRepository.findAll();
	}
	

	public Plante findPlante(int id) {
		if(planteRepository.findById(id).isPresent()) {
			Plante existingPlante = planteRepository.findById(id).get();
			return existingPlante;
		}
		else {
			return null;
		}
	}
	
	
	
	
}
