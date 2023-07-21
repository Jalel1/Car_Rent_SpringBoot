package com.locationVoiture.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "modeles"})
public class Famille {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String type;
	
	@OneToMany(mappedBy="famille")
	private List<Modele> modeles=  new ArrayList<Modele>();

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Modele> getModeles() {
		return modeles;
	}

	public void setModeles(List<Modele> modeles) {
		this.modeles = modeles;
	}
	
	
}
