package com.guichet.banque.service.clientservice;

import java.util.List;

import com.guichet.banque.model.Carte;
import com.guichet.banque.model.Client;
import com.guichet.banque.model.Compte;
import com.guichet.banque.model.ResultVerif;

public interface ClientService {
	
	public Client getClientById(Long id);
	
	public Client getClientByLogin(String login);
	
	public List<Client> getAllClient();
	
	public Client addClient(Client client);
	
	public boolean clientExist(Long id);
	
	public Client updateClient(Long id,Client client);
	
	public void deleteClient(Long id);
	
	public Client getClientByNumeroCompte(Compte numeroCompte);
	
	public Client getClientByNumeroCarte(Carte carte);
	
	public ResultVerif verifierInfoClient(Carte carte, Double montant);
	
	

}
