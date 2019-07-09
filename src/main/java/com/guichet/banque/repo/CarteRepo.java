package com.guichet.banque.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guichet.banque.model.Carte;

@Repository
public interface CarteRepo extends JpaRepository<Carte, Long>{
	
	@Query("select c from Carte c where c.numeroCarte = ?1")
	public Carte getCarteByNumCarte(Integer numCarte);

}
