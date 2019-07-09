package com.guichet.banque.service.cartecervice;

import java.util.List;

import com.guichet.banque.model.Carte;

public interface CarteService {
	
	public Carte getCarteByNumeroCarte(Integer numCarte);
	
	public boolean validCarte(Carte carte);
	
	public List<Carte> getAllCarte();
	
	public Carte getCarteById(Long id);

}
