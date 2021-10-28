package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	//Requete de recherche d'un Employe par son nom
	//http://localhost:8181/employes/search/employeByNom?nom=Khalil
	@Query("select c from Employe c where c.nom like :nom")
	public Page<Employe> employeByNom(@Param("nom") String n, Pageable pageable);
	
}
