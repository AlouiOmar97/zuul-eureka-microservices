package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.AnimalProduct;



public interface AnimalProductRepository extends CrudRepository<AnimalProduct, Integer>  {
	


    
    @Modifying
    @Transactional
    @Query("UPDATE AnimalProduct e SET e.price=:price where e.id=:animalProductId")
    public void mettreAjourPriceByAnimalProductIdJPQL(@Param("price")int price, @Param("animalProductId")int animalProductId);

    

	
    		
   

}
