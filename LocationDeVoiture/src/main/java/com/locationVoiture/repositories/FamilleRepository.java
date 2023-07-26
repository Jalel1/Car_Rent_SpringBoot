package com.locationVoiture.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.locationVoiture.entities.Famille;


public interface FamilleRepository extends JpaRepository<Famille, Long> {

}
