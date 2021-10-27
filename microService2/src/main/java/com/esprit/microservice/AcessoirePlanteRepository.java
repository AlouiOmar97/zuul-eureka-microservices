package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AcessoirePlanteRepository extends JpaRepository<AcessoirePlante, Integer> {
	
	@Query("select c from AcessoirePlante c where c.nom like :nom")
	public Page<AcessoirePlante> AcessoirePlanteByNom(@Param("nom") String n, Pageable pageable);
	
}
