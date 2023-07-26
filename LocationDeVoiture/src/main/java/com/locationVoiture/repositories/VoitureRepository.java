package com.locationVoiture.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.locationVoiture.entities.Voiture;


public interface VoitureRepository extends JpaRepository<Voiture, Long>{

}
