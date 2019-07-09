package com.guichet.banque.service.cartecervice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guichet.banque.model.Carte;
import com.guichet.banque.repo.CarteRepo;
import com.guichet.banque.service.cartecervice.CarteService;

@Service
public class CarteServiceImpl implements CarteService {

	@Autowired
	private CarteRepo carteRepo;
	
	@Override
	public Carte getCarteByNumeroCarte(Integer numCarte) {
		return carteRepo.getCarteByNumCarte(numCarte);
	}

	@Override
	public boolean validCarte(Carte carte) {
		Carte savedCarte = getCarteByNumeroCarte(carte.getNumeroCarte());
		if(savedCarte != null)
		{
			if(savedCarte.equals(carte)){
				return true;
			}
			return false;
		}			
		return false;
	}

	@Override
	public List<Carte> getAllCarte() {
		// TODO Auto-generated method stub
		return carteRepo.findAll();
	}

	@Override
	public Carte getCarteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
