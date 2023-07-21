package com.locationVoiture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.locationVoiture.entities.Famille;
import com.locationVoiture.services.FamilleService;

@Controller
@RequestMapping("/famille")
public class FamilleController {

	@Autowired
	private FamilleService familleS;
	
	@RequestMapping("/addFamille")
	public String addFamille(Model model) {
		Famille familleController = new Famille();
		model.addAttribute("familleView", familleController);
		return "new_famille";
	}
	
	@PostMapping("/save")
	public String saveFamille(@ModelAttribute("familleView") Famille famille) {
		
		familleS.saveFamille(famille);
		
		return "redirect: /famille/listeFamille";
	}
	
	@RequestMapping("/listeFamille")
	public String listeFamille(Model m) {
		
		List<Famille> listeFamilleC= familleS.listFamille();
		m.addAttribute("listeFamilleView", listeFamilleC);
		
		return "liste_famille";
	}
	
	@RequestMapping("/delete/{idF}")
	public String deleteFamille(@PathVariable("idF") long id) {
		familleS.deleteFamille(id);	
		return "redirect:/famille/listeFamille";
		}
	
	@RequestMapping("/edit/{id}")
	public String ShowUpdateFamille(@PathVariable("id") long id, Model m) {
		Famille familleC = familleS.getfamille(id);
		m.addAttribute("familleMAJView", familleC);
		return "update_famille";
	}
	
	@PostMapping("/update/{id}")
	public String MAJFamille(@PathVariable("id") long id, 
			@ModelAttribute("familleMAJView") Famille f) {

		familleS.saveFamille(f);
		return "redirect: /famille/listeFamille";
	}
	
}
