package com.guichet.banque.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guichet.banque.model.Compte;

@Repository
public interface CompteRepo extends JpaRepository<Compte, Long> {
	
	@Query("select c from Compte c where c.numeroCompte = ?1")
	public Compte getCompteByNumeroCompte(Integer numCompte);
	
//	@Query("select c from Compte c where c.cartes.idCarte = ?1")
//	public Compte getCompteByIdCarte(Long idCarte);

}
