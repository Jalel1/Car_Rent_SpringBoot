package com.locationVoiture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationVoiture.entities.Voiture;
import com.locationVoiture.repositories.VoitureRepository;

@Service
public class VoitureService {

	@Autowired
	private VoitureRepository voitureRepo;
	
	//Liste des voitures
	public List<Voiture> listVoiture(){
		
		return voitureRepo.findAll();
	}
	
	//Ajouter une voiture
	public void saveVoiture(Voiture voiture) {
		
		voitureRepo.save(voiture);
	}
	
	//Récuperer une voiture par un id
	public Voiture getVoiture(long id) {
		return voitureRepo.findById(id).get();
	}
	
	//Supprimer une voiture par un id
	public void deleteVoiture(long id) {
		voitureRepo.deleteById(id);
	}
	
	//Supprimer 
		public void deleteAll() {
			voitureRepo.deleteAll();
		}
	
}
