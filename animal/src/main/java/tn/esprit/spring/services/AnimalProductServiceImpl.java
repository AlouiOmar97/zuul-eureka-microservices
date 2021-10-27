package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.AnimalProduct;
import tn.esprit.spring.repository.AnimalProductRepository;

@Service
public class AnimalProductServiceImpl implements IAnimalProductService {

	@Autowired
	AnimalProductRepository animalProductRepository;


	public int ajouterAnimalProduct(AnimalProduct animalProduct) {
		animalProductRepository.save(animalProduct);
		return animalProduct.getId();
	}



	@Transactional
	public void mettreAjourPriceByAnimalProductId(int price, int animalProductId) {
		AnimalProduct animalProduct = animalProductRepository.findById(animalProductId).get();
		animalProduct.setPrice(price);
		animalProductRepository.save(animalProduct);

	}

//	@Transactional
//	public void affecterAnimalProductADepartement(int animalProductId, int depId) {
//		Departement depManagedEntity = deptRepoistory.findById(depId).get();
//		AnimalProduct animalProductManagedEntity = animalProductRepository.findById(animalProductId).get();
//
//		if(depManagedEntity.getAnimalProducts() == null){
//
//			List<AnimalProduct> animalProducts = new ArrayList<>();
//			animalProducts.add(animalProductManagedEntity);
//			depManagedEntity.setAnimalProducts(animalProducts);
//		}else{
//
//			depManagedEntity.getAnimalProducts().add(animalProductManagedEntity);
//
//		}
//
//	}

	public AnimalProduct getAnimalProductById(int animalProductId) {
		return animalProductRepository.findById(animalProductId).get();

	}
	public void deleteAnimalProductById(int animalProductId)
	{
		AnimalProduct animalProduct = animalProductRepository.findById(animalProductId).get();

		animalProductRepository.delete(animalProduct);
	}

//	public void deleteContratById(int contratId) {
//		Contrat contratManagedEntity = contratRepoistory.findById(contratId).get();
//		contratRepoistory.delete(contratManagedEntity);
//
//	}
//
//
//
//	public List<Timesheet> getTimesheetsByMissionAndDate(AnimalProduct animalProduct, Mission mission, Date dateDebut,
//			Date dateFin) {
//		return timesheetRepository.getTimesheetsByMissionAndDate(animalProduct, mission, dateDebut, dateFin);
//	}

	public List<AnimalProduct> getAllAnimalProducts() {
				return (List<AnimalProduct>) animalProductRepository.findAll();
	}

}
