package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.AnimalProduct;


public interface IAnimalProductService {
	
	public int ajouterAnimalProduct(AnimalProduct animalProduct);


	public AnimalProduct getAnimalProductById(int animalProductId);
	public void deleteAnimalProductById(int animalProductId);


	public List<AnimalProduct> getAllAnimalProducts();

	
	

	
}
