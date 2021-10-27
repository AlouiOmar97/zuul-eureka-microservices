package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.Review;
import tn.esprit.spring.services.IReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestControlReview {

	
	@Autowired
	IReviewService ireviewservice;


	@GetMapping(value = "/")
	@ResponseBody
	public String Hello() {

		return "hello";
	}
	
	// http://localhost:8081/SpringMVC/servlet/ajouterReviewr
	//{"id":1,"nom":"kallel", "prenom":"khaled", "email":"Khaled.kallel@ssiiconsulting.tn", "isActif":true, "role":"INGENIEUR"}

	@PostMapping("/ajouterReviewr")
	@ResponseBody
	public Review ajouterReview(@RequestBody Review review)
	{
		ireviewservice.ajouterReview(review);
		return review;
	}
	
	// Modifier email : http://localhost:8081/SpringMVC/servlet/modifyEmail/1/newemail
//	@PutMapping(value = "/modifyEmail/{id}/{newemail}")
//	@ResponseBody
//	public void mettreAjourEmailByReviewId(@PathVariable("newemail") String email, @PathVariable("id") int reviewId) {
//		ireviewservice.mettreAjourEmailByReviewId(email, reviewId);
//
//	}
//	// http://localhost:8081/SpringMVC/servlet/affecterReviewADepartement/1/1
//	@PutMapping(value = "/affecterReviewADepartement/{idemp}/{iddept}")
//	public void affecterReviewADepartement(@PathVariable("idemp")int reviewId, @PathVariable("iddept")int depId) {
//		ireviewservice.affecterReviewADepartement(reviewId, depId);
//
//	}
//
//	// http://localhost:8081/SpringMVC/servlet/desaffecterReviewDuDepartement/1/1
//	@PutMapping(value = "/desaffecterReviewDuDepartement/{idemp}/{iddept}")
//	public void desaffecterReviewDuDepartement(@PathVariable("idemp")int reviewId, @PathVariable("iddept")int depId)
//	{
//		ireviewservice.desaffecterReviewDuDepartement(reviewId, depId);
//	}
//
//	// http://localhost:8081/SpringMVC/servlet/ajouterContrat
//	//{"reference":6,"dateDebut":"2020-03-01","salaire":2000,"typeContrat":"CDD"}
//	@PostMapping("/ajouterContrat")
//	@ResponseBody
//	public int ajouterContrat(@RequestBody Contrat contrat) {
//		ireviewservice.ajouterContrat(contrat);
//		return contrat.getReference();
//	}
//
//	// http://localhost:8081/SpringMVC/servlet/affecterContratAReview/6/1
//   @PutMapping(value = "/affecterContratAReview/{idcontrat}/{idemp}")
//	public void affecterContratAReview(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int reviewId)
//	{
//		ireviewservice.affecterContratAReview(contratId, reviewId);
//	}

	
   
   // URL : http://localhost:8081/SpringMVC/servlet/getReviewPrenomById/2
   @GetMapping(value = "getReviewById/{idp}")
   @ResponseBody
   public Review getReviewPrenomById(@PathVariable("idp")int reviewId) {
		return ireviewservice.getReviewById(reviewId);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/deleteReviewById/1
    @DeleteMapping("/deleteReviewById/{idemp}")
	@ResponseBody 
	public void deleteReviewById(@PathVariable("idemp")int reviewId) {
		ireviewservice.deleteReviewById(reviewId);
		
	}
    
 // URL : http://localhost:8081/SpringMVC/servlet/deleteContratById/2
//    @DeleteMapping("/deleteContratById/{idcontrat}")
//	@ResponseBody
//	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
//		ireviewservice.deleteContratById(contratId);
//	}
//
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getNombreReviewJPQL
//    @GetMapping(value = "getNombreReviewJPQL")
//    @ResponseBody
//	public int getNombreReviewJPQL() {
//
//		return ireviewservice.getNombreReviewJPQL();
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getAllReviewNamesJPQL
//    @GetMapping(value = "getAllReviewNamesJPQL")
//    @ResponseBody
//	public List<String> getAllReviewNamesJPQL() {
//
//		return ireviewservice.getAllReviewNamesJPQL();
//	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllReviewByEntreprise/1
//    @GetMapping(value = "getAllReviewByEntreprise/{identreprise}")
//    @ResponseBody
//	public List<Review> getAllReviewByEntreprise(@PathVariable("identreprise") int identreprise) {
//    	Entreprise entreprise=ientrepriseservice.getEntrepriseById(identreprise);
//		return ireviewservice.getAllReviewByEntreprise(entreprise);
//	}
//
// // Modifier email : http://localhost:8081/SpringMVC/servlet/mettreAjourEmailByReviewIdJPQL/2/newemail
// 	@PutMapping(value = "/mettreAjourEmailByReviewIdJPQL/{id}/{newemail}")
// 	@ResponseBody
//	public void mettreAjourEmailByReviewIdJPQL(@PathVariable("newemail") String email, @PathVariable("id") int reviewId) {
//	ireviewservice.mettreAjourEmailByReviewIdJPQL(email, reviewId);
//
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/deleteAllContratJPQL
//    @DeleteMapping("/deleteAllContratJPQL")
//	@ResponseBody
//	public void deleteAllContratJPQL() {
//		ireviewservice.deleteAllContratJPQL();
//
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireByReviewIdJPQL/2
//    @GetMapping(value = "getSalaireByReviewIdJPQL/{idemp}")
//    @ResponseBody
//	public float getSalaireByReviewIdJPQL(@PathVariable("idemp")int reviewId) {
//		return ireviewservice.getSalaireByReviewIdJPQL(reviewId);
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireMoyenByDepartementId/2
//    @GetMapping(value = "getSalaireMoyenByDepartementId/{iddept}")
//    @ResponseBody
//	public Double getSalaireMoyenByDepartementId(@PathVariable("iddept")int departementId) {
//		return ireviewservice.getSalaireMoyenByDepartementId(departementId);
//	}
//
//
//	//
//	public List<Timesheet> getTimesheetsByMissionAndDate(Review review, Mission mission, Date dateDebut,
//			Date dateFin) {
//		return ireviewservice.getTimesheetsByMissionAndDate(review, mission, dateDebut, dateFin);
//	}


	 // URL : http://localhost:8081/SpringMVC/servlet/getAllReviews
	@GetMapping(value = "/getAllReviews")
    @ResponseBody
	public List<Review> getAllReviews() {
		
		return ireviewservice.getAllReviews();
	}


	@GetMapping(value = "/getAllProductReviews/{idp}")
	@ResponseBody
	public List<Review> getAllProductReviews(@PathVariable("idp")int idp) {

		return ireviewservice.getReviewsByProductId(idp);
	}

	
	
}
