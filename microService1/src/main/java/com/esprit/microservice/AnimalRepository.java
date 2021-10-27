package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
	@Query("select c from Animal c where c.nom like :nom")
	public Page<Animal> candidatByNom(@Param("nom") String n, Pageable pageable);
	
}
