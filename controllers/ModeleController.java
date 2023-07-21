package com.locationVoiture.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.locationVoiture.entities.Famille;
import com.locationVoiture.entities.Modele;
import com.locationVoiture.services.FamilleService;
import com.locationVoiture.services.ModelService;

@Controller
public class ModeleController {

	@Autowired
	private ModelService modeleS;
	
	@Autowired
	private FamilleService familleS;
	
	//affichage d'un formulaire d'ajout d'un modele
	@RequestMapping("/addModele")
	public String showModeleForm(Model  model) {
		
		Modele modele = new Modele();
		List<Famille> listeF = familleS.listFamille();
		
		model.addAttribute("modeleForm", modele);
		model.addAttribute("listeFamille", listeF);
		
		return "new_modele";
	}
	
	//Save d'un modèle ds la BD
	@RequestMapping(value="/saveModele", method= RequestMethod.POST)
	public String saveModele(@ModelAttribute("modeleForm") Modele m) {
		modeleS.saveModel(m);
		return "redirect: /listeModele";
	}
	
	//liste de tous les modèles
	@RequestMapping("/listeModele")
	public String listeModeles(Model model) {
		//1- Recuperation de tous les modèles
		List<Modele> listeM = modeleS.listModel();
		
		//2- lien avec View
		model.addAttribute("listeModele", listeM);
		
		return "liste_modeles";
	}
	
		@GetMapping("/updateModele/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
			Modele m = modeleS.getmodel(id);
			model.addAttribute("ModelMAJ", m );
	List<Famille> listeF = familleS.listFamille();
			model.addAttribute("listeFamille", listeF);
			return "update_model";
	    }

	    @PostMapping("update/{id}")
	    public String updateVoiture(@PathVariable("id") long id, @Valid Modele modele, 
	    		BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            modele.setId(id);
	            return "update_model";
	        }

	        modeleS.saveModel(modele);
	        return "redirect:/listeModele";
	    }

	    
	@GetMapping("delete/{id}")
	    public String deleteModele(@PathVariable("id") long id) {
	    	modeleS.deleteModel(id);	
	        return "redirect:/listeModele";
	    }
	
}
