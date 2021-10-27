package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Review;


public interface IReviewService {
	
	public int ajouterReview(Review review);


	public Review getReviewById(int reviewId);
	public List<Review> getReviewsByProductId(int reviewId);
	public void deleteReviewById(int reviewId);


	public List<Review> getAllReviews();

	
	

	
}
