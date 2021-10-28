package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeService {

	
	@Autowired
	private EmployeRepository employeRepository;
	
	
	//Ajouter un employe
	public Employe addEmploye(Employe employe) {
		return employeRepository.save(employe);
	}
	
	
	//Mettre a jour les informations d'un employe
	public Employe updateEmploye(int id, Employe newEmploye) {
		if(employeRepository.findById(id).isPresent()) {
			Employe existingEmploye = employeRepository.findById(id).get();
			existingEmploye.setNom(newEmploye.getNom());
			existingEmploye.setPrenom(newEmploye.getPrenom());
			existingEmploye.setEmail(newEmploye.getEmail());
			existingEmploye.setPassword(newEmploye.getPassword());
			
			return employeRepository.save(existingEmploye);
		}
		else {
			return null;
		}
	}
	
	
	//Supprimer un employe
	public String deleteEmploye(int id) {
		if(employeRepository.findById(id).isPresent()) {
			employeRepository.deleteById(id);
			return "L'employe avec l'id " + id + " a ete supprime";
		}
		else {
			return "L'employe avec l'id " + id + " n'a pas ete supprime";
		}
	}
	
	
	
	//Obtenir tous les employes
	public  List<Employe> GetEmployes() {
		return employeRepository.findAll();
	}
	
	
	//Chercher un employe
	public Employe findEmploye(int id) {
		if(employeRepository.findById(id).isPresent()) {
			Employe existingEmploye= employeRepository.findById(id).get();
			return existingEmploye;
		}
		else {
			return null;
		}
	}
	
	
	
	
}
