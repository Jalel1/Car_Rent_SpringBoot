package com.locationVoiture.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.locationVoiture.entities.Modele;



public interface ModeleRepository extends JpaRepository<Modele, Long> {

}
