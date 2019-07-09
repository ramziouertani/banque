package com.guichet.banque.service;


import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.guichet.banque.model.Carte;
import com.guichet.banque.model.Client;
import com.guichet.banque.model.Compte;
import com.guichet.banque.repo.ClientRepo;
import com.guichet.banque.service.clientservice.ClientService;
import com.guichet.banque.service.clientservice.impl.ClientServiceImpl;

@RunWith(SpringRunner.class)
public class TestClientServices {
	
	@TestConfiguration
	public static class ConfigurationTestClientService{
		
		@Bean
		public ClientService clientService() {
			return new ClientServiceImpl();
		}
		
	}
	
	@MockBean
	private ClientRepo clientRepo;
	
	@Autowired
	private ClientService clientService;
	
	public Client client1 = null;
	public Compte compte1 , compte2 = null;
	public Carte carte1, carte2 = null;
	
	@Before
	public void setUp() {
		
		carte1 = new Carte();
		  carte1.setIdCarte(1L);
		  carte1.setNumeroCarte(123456);
		  carte1.setProprietaire("Ramzi");
	   carte2 = new Carte();
	      carte2.setIdCarte(2L);
	      carte2.setNumeroCarte(258147);
	      carte2.setProprietaire("safa");
	      
	   compte1 = new Compte(); 
	     compte1.setId(1L);
	     Set<Carte> cartes = new HashSet<Carte>();
	     cartes.add(carte1);
	     cartes.add(carte2);
		 compte1.setCartes(cartes);
		 compte1.setNumeroCompte(12345688);
		client1 = new Client();
		  client1.setId(1L);
	    Set<Compte> comptes = new HashSet<Compte>();
		     comptes.add(compte1);
		  client1.setComptes(comptes);
		
	}
	
	@Test
	public void getClientByNumeroCarte() {
		
		Mockito.when(clientRepo.getClientByNumCarte(123456)).thenReturn(client1);
		Client client = clientService.getClientByNumeroCarte(carte1);
		Assert.assertEquals(client.getId(), client1.getId());
	}
	

}
