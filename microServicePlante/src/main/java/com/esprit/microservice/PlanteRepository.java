package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlanteRepository extends JpaRepository<Plante, Integer> {
	
	/*@Query("select c from Animal c where c.nom like :nom")
	public Page<Plante> candidatByNom(@Param("nom") String n, Pageable pageable);*/
	
}
