package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AcessoirePlanteService {

	
	@Autowired
	private AcessoirePlanteRepository acessoirePlanteRepository;
	
	
	//Ajouter un acessoirePlante
	public AcessoirePlante addAcessoirePlante(AcessoirePlante acessoirePlante) {
		return acessoirePlanteRepository.save(acessoirePlante);
	}
	
	
	//Mettre a jour les informations d'un acessoirePlante
	public AcessoirePlante updateAcessoirePlante(int id, AcessoirePlante newAcessoirePlante) {
		if(acessoirePlanteRepository.findById(id).isPresent()) {
			AcessoirePlante existingAcessoirePlante = acessoirePlanteRepository.findById(id).get();
			existingAcessoirePlante.setNom(newAcessoirePlante.getNom());
			existingAcessoirePlante.setGenre(newAcessoirePlante.getGenre());
			existingAcessoirePlante.setCouleur(newAcessoirePlante.getCouleur());
				existingAcessoirePlante.setPrix(newAcessoirePlante.getPrix());
			return acessoirePlanteRepository.save(existingAcessoirePlante);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer un acessoirePlante
	public String deleteAcessoirePlante(int id) {
		if(acessoirePlanteRepository.findById(id).isPresent()) {
			acessoirePlanteRepository.deleteById(id);
			return "Le acessoirePlante avec l'id " + id + " a ete supprime";
		}
		else {
			return "Le acessoirePlante avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les acessoirePlantes
	public  List<AcessoirePlante> GetAcessoirePlantes() {
		return acessoirePlanteRepository.findAll();
	}
	
	//Methode additionnelle (Pas dans l'atelier)
	//Chercher un acessoirePlante
	public AcessoirePlante findAcessoirePlante(int id) {
		if(acessoirePlanteRepository.findById(id).isPresent()) {
			AcessoirePlante existingAcessoirePlante = acessoirePlanteRepository.findById(id).get();
			return existingAcessoirePlante;
		}
		else {
			return null;
		}
	}
	
	
	
	
}
