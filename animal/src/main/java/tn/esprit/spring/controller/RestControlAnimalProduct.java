package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.AnimalProduct;
import tn.esprit.spring.services.IAnimalProductService;

@RestController
public class RestControlAnimalProduct {

	
	@Autowired
	IAnimalProductService ianimalProductservice;


	@GetMapping(value = "/")
	@ResponseBody
	public String Hello() {

		return "hello";
	}
	
	// http://localhost:8081/SpringMVC/servlet/ajouterAnimalProductr
	//{"id":1,"nom":"kallel", "prenom":"khaled", "email":"Khaled.kallel@ssiiconsulting.tn", "isActif":true, "role":"INGENIEUR"}

	@PostMapping("/ajouterAnimalProductr")
	@ResponseBody
	public AnimalProduct ajouterAnimalProduct(@RequestBody AnimalProduct animalProduct)
	{
		ianimalProductservice.ajouterAnimalProduct(animalProduct);
		return animalProduct;
	}
	
	// Modifier email : http://localhost:8081/SpringMVC/servlet/modifyEmail/1/newemail
//	@PutMapping(value = "/modifyEmail/{id}/{newemail}")
//	@ResponseBody
//	public void mettreAjourEmailByAnimalProductId(@PathVariable("newemail") String email, @PathVariable("id") int animalProductId) {
//		ianimalProductservice.mettreAjourEmailByAnimalProductId(email, animalProductId);
//
//	}
//	// http://localhost:8081/SpringMVC/servlet/affecterAnimalProductADepartement/1/1
//	@PutMapping(value = "/affecterAnimalProductADepartement/{idemp}/{iddept}")
//	public void affecterAnimalProductADepartement(@PathVariable("idemp")int animalProductId, @PathVariable("iddept")int depId) {
//		ianimalProductservice.affecterAnimalProductADepartement(animalProductId, depId);
//
//	}
//
//	// http://localhost:8081/SpringMVC/servlet/desaffecterAnimalProductDuDepartement/1/1
//	@PutMapping(value = "/desaffecterAnimalProductDuDepartement/{idemp}/{iddept}")
//	public void desaffecterAnimalProductDuDepartement(@PathVariable("idemp")int animalProductId, @PathVariable("iddept")int depId)
//	{
//		ianimalProductservice.desaffecterAnimalProductDuDepartement(animalProductId, depId);
//	}
//
//	// http://localhost:8081/SpringMVC/servlet/ajouterContrat
//	//{"reference":6,"dateDebut":"2020-03-01","salaire":2000,"typeContrat":"CDD"}
//	@PostMapping("/ajouterContrat")
//	@ResponseBody
//	public int ajouterContrat(@RequestBody Contrat contrat) {
//		ianimalProductservice.ajouterContrat(contrat);
//		return contrat.getReference();
//	}
//
//	// http://localhost:8081/SpringMVC/servlet/affecterContratAAnimalProduct/6/1
//   @PutMapping(value = "/affecterContratAAnimalProduct/{idcontrat}/{idemp}")
//	public void affecterContratAAnimalProduct(@PathVariable("idcontrat")int contratId, @PathVariable("idemp")int animalProductId)
//	{
//		ianimalProductservice.affecterContratAAnimalProduct(contratId, animalProductId);
//	}

	
   
   // URL : http://localhost:8081/SpringMVC/servlet/getAnimalProductPrenomById/2
   @GetMapping(value = "getAnimalProductById/{idp}")
   @ResponseBody
   public AnimalProduct getAnimalProductPrenomById(@PathVariable("idp")int animalProductId) {
		return ianimalProductservice.getAnimalProductById(animalProductId);
	}

    // URL : http://localhost:8081/SpringMVC/servlet/deleteAnimalProductById/1
    @DeleteMapping("/deleteAnimalProductById/{idemp}")
	@ResponseBody 
	public void deleteAnimalProductById(@PathVariable("idemp")int animalProductId) {
		ianimalProductservice.deleteAnimalProductById(animalProductId);
		
	}
    
 // URL : http://localhost:8081/SpringMVC/servlet/deleteContratById/2
//    @DeleteMapping("/deleteContratById/{idcontrat}")
//	@ResponseBody
//	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
//		ianimalProductservice.deleteContratById(contratId);
//	}
//
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getNombreAnimalProductJPQL
//    @GetMapping(value = "getNombreAnimalProductJPQL")
//    @ResponseBody
//	public int getNombreAnimalProductJPQL() {
//
//		return ianimalProductservice.getNombreAnimalProductJPQL();
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getAllAnimalProductNamesJPQL
//    @GetMapping(value = "getAllAnimalProductNamesJPQL")
//    @ResponseBody
//	public List<String> getAllAnimalProductNamesJPQL() {
//
//		return ianimalProductservice.getAllAnimalProductNamesJPQL();
//	}

    // URL : http://localhost:8081/SpringMVC/servlet/getAllAnimalProductByEntreprise/1
//    @GetMapping(value = "getAllAnimalProductByEntreprise/{identreprise}")
//    @ResponseBody
//	public List<AnimalProduct> getAllAnimalProductByEntreprise(@PathVariable("identreprise") int identreprise) {
//    	Entreprise entreprise=ientrepriseservice.getEntrepriseById(identreprise);
//		return ianimalProductservice.getAllAnimalProductByEntreprise(entreprise);
//	}
//
// // Modifier email : http://localhost:8081/SpringMVC/servlet/mettreAjourEmailByAnimalProductIdJPQL/2/newemail
// 	@PutMapping(value = "/mettreAjourEmailByAnimalProductIdJPQL/{id}/{newemail}")
// 	@ResponseBody
//	public void mettreAjourEmailByAnimalProductIdJPQL(@PathVariable("newemail") String email, @PathVariable("id") int animalProductId) {
//	ianimalProductservice.mettreAjourEmailByAnimalProductIdJPQL(email, animalProductId);
//
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/deleteAllContratJPQL
//    @DeleteMapping("/deleteAllContratJPQL")
//	@ResponseBody
//	public void deleteAllContratJPQL() {
//		ianimalProductservice.deleteAllContratJPQL();
//
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireByAnimalProductIdJPQL/2
//    @GetMapping(value = "getSalaireByAnimalProductIdJPQL/{idemp}")
//    @ResponseBody
//	public float getSalaireByAnimalProductIdJPQL(@PathVariable("idemp")int animalProductId) {
//		return ianimalProductservice.getSalaireByAnimalProductIdJPQL(animalProductId);
//	}
//
//    // URL : http://localhost:8081/SpringMVC/servlet/getSalaireMoyenByDepartementId/2
//    @GetMapping(value = "getSalaireMoyenByDepartementId/{iddept}")
//    @ResponseBody
//	public Double getSalaireMoyenByDepartementId(@PathVariable("iddept")int departementId) {
//		return ianimalProductservice.getSalaireMoyenByDepartementId(departementId);
//	}
//
//
//	//
//	public List<Timesheet> getTimesheetsByMissionAndDate(AnimalProduct animalProduct, Mission mission, Date dateDebut,
//			Date dateFin) {
//		return ianimalProductservice.getTimesheetsByMissionAndDate(animalProduct, mission, dateDebut, dateFin);
//	}


	 // URL : http://localhost:8081/SpringMVC/servlet/getAllAnimalProducts
	@GetMapping(value = "/getAllAnimalProducts")
    @ResponseBody
	public List<AnimalProduct> getAllAnimalProducts() {
		
		return ianimalProductservice.getAllAnimalProducts();
	}

	
	
}
