package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Review;



public interface ReviewRepository extends CrudRepository<Review, Integer>  {
	


    
    @Modifying
    @Transactional
    @Query("UPDATE Review e SET e.content=:content where e.id=:reviewId")
    public void mettreAjourContentByReviewIdJPQL(@Param("content")int content, @Param("reviewId")int reviewId);


    List<Review> findByIdp(int idp);

    

	
    		
   

}
