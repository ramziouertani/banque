package com.guichet.banque.service.compteservice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guichet.banque.model.Compte;
import com.guichet.banque.repo.CompteRepo;
import com.guichet.banque.service.compteservice.CompteService;

@Service
public class CompteServiceImpl implements CompteService {

	@Autowired
	private CompteRepo compteRepo;
	
	@Override
	public List<Compte> getAllCompte() {
		return compteRepo.findAll();
	}

	@Override
	public Compte getCompteByNumeroCompte(Integer numeroCompte) {
		return compteRepo.getCompteByNumeroCompte(numeroCompte);
	}

	@Override
	public Compte getCompteById(Long id) {

		Optional<Compte> optional = compteRepo.findById(id);
		if(!optional.isPresent())
           return null;
		return optional.get();
	}

	@Override
	public Compte getCompteByIdCarte(Long idCarte) {
		return null;
	}

}
