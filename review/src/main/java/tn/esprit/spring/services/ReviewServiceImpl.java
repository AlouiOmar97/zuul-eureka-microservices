package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Review;
import tn.esprit.spring.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	ReviewRepository reviewRepository;


	public int ajouterReview(Review review) {
		reviewRepository.save(review);
		return review.getId();
	}



	@Transactional
	public void mettreAjourContentByReviewId(String content, int reviewId) {
		Review review = reviewRepository.findById(reviewId).get();
		review.setContent(content);
		reviewRepository.save(review);

	}

//	@Transactional
//	public void affecterReviewADepartement(int reviewId, int depId) {
//		Departement depManagedEntity = deptRepoistory.findById(depId).get();
//		Review reviewManagedEntity = reviewRepository.findById(reviewId).get();
//
//		if(depManagedEntity.getReviews() == null){
//
//			List<Review> reviews = new ArrayList<>();
//			reviews.add(reviewManagedEntity);
//			depManagedEntity.setReviews(reviews);
//		}else{
//
//			depManagedEntity.getReviews().add(reviewManagedEntity);
//
//		}
//
//	}

	public Review getReviewById(int reviewId) {
		return reviewRepository.findById(reviewId).get();

	}
	public void deleteReviewById(int reviewId)
	{
		Review review = reviewRepository.findById(reviewId).get();

		reviewRepository.delete(review);
	}

//	public void deleteContratById(int contratId) {
//		Contrat contratManagedEntity = contratRepoistory.findById(contratId).get();
//		contratRepoistory.delete(contratManagedEntity);
//
//	}
//
//
//
//	public List<Timesheet> getTimesheetsByMissionAndDate(Review review, Mission mission, Date dateDebut,
//			Date dateFin) {
//		return timesheetRepository.getTimesheetsByMissionAndDate(review, mission, dateDebut, dateFin);
//	}

	public List<Review> getAllReviews() {
				return (List<Review>) reviewRepository.findAll();
	}
	public List<Review> getReviewsByProductId(int idp) {
		return (List<Review>) reviewRepository.findByIdp(idp);
	}

}
