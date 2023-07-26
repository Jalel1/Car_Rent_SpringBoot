package com.locationVoiture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationVoiture.entities.Famille;
import com.locationVoiture.entities.Modele;
import com.locationVoiture.repositories.FamilleRepository;
import com.locationVoiture.repositories.ModeleRepository;

@Service
public class FamilleService {

	@Autowired
	private FamilleRepository famillerepo;
	
	//Liste des familles
	public List<Famille> listFamille(){
		
		return famillerepo.findAll();
	}
	
	//Ajouter une famille
	public void saveFamille(Famille famille) {
		
		famillerepo.save(famille);
	}
	
	//Récuperer une famille par un id
	public Famille getfamille(long id) {
		return famillerepo.findById(id).get();
	}
	
	//Supprimer une famille par un id
	public void deleteFamille(long id) {
		famillerepo.deleteById(id);
	}
	
}
