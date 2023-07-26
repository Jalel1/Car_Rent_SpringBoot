package com.locationVoiture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationVoiture.entities.Modele;
import com.locationVoiture.repositories.ModeleRepository;

@Service
public class ModelService {

	@Autowired
	private ModeleRepository modelRepo;
	
	//Liste des modèles
	public List<Modele> listModel(){
		
		return modelRepo.findAll();
	}
	
	//Ajouter un model
	public void saveModel(Modele model) {
		
		modelRepo.save(model);
	}
	
	//Récuperer un model par un id
	public Modele getmodel(long id) {
		return modelRepo.findById(id).get();
	}
	
	//Supprimer un model par un id
	public void deleteModel(long id) {
		modelRepo.deleteById(id);
	}
	
}
