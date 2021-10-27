package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	
	@Query("select c from Blog c where c.titre like :titre")
	public Page<Blog> candidatByNom(@Param("titre") String n, Pageable pageable);
	
}
