package com.guichet.banque.service.compteservice;

import java.util.List;

import com.guichet.banque.model.Compte;

public interface CompteService {
	
	public List<Compte> getAllCompte();
	
	public Compte getCompteByNumeroCompte(Integer numeroCompte);
	
	public Compte getCompteById(Long id);
	
	public Compte getCompteByIdCarte(Long idCarte);

}
