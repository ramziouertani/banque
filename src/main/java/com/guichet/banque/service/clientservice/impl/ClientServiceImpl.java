package com.guichet.banque.service.clientservice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guichet.banque.model.Carte;
import com.guichet.banque.model.Client;
import com.guichet.banque.model.Compte;
import com.guichet.banque.model.ResultVerif;
import com.guichet.banque.repo.ClientRepo;
import com.guichet.banque.service.clientservice.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepo clientRepo;
	
	@Override
	public Client getClientById(Long id) {
		Optional<Client> optional = clientRepo.findById(id);
		  if(optional.isPresent())
			  return optional.get();
		  return null;
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepo.findAll();
	}

	@Override
	public Client addClient(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public boolean clientExist(Long id) {
		return clientRepo.existsById(id);
	}

	@Override
	public Client updateClient(Long id, Client client) {
		
		Client savedClient = getClientById(id);
		
		if(savedClient != null)
		{
			
		}
		return null;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client getClientByLogin(String login) {
		return clientRepo.getClientByLogin(login);
	}

	@Override
	public ResultVerif verifierInfoClient(Carte carte, Double montant) {	
//		ResultVerif result = null;
//		if(!carteService.validCarte(carte))	{
//			result = new ResultVerif();
//			  result.
//			  return result;
//
//		}			
//		
//		Compte compte = compteService.getCompteByIdCarte(carte.getIdCarte());
//		  if(compte.getMontant() < montant) {
//			  
//			  
//		  }
		
		return null;
			  
	}

	@Override
	public Client getClientByNumeroCompte(Compte compte) {
		return null;
	}

	@Override
	public Client getClientByNumeroCarte(Carte carte) {
		return clientRepo.getClientByNumCarte(carte.getNumeroCarte());
	}

}
