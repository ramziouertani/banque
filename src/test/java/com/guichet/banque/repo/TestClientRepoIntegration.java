package com.guichet.banque.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guichet.banque.model.Carte;
import com.guichet.banque.model.Client;
import com.guichet.banque.model.Compte;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestClientRepoIntegration {
	
	@PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private ClientRepo clientRepo;
 
    @Test
    public void testGetClientByNumeroCarte_ReturnSucced() {
		Carte carte1 = new Carte();
		  carte1.setIdCarte(1L);
		  carte1.setNumeroCarte(147258);
		  carte1.setProprietaire("Ramzi Ouertani");
	      
	   Compte compte1 = new Compte(); 
	     compte1.setId(1L);
	     compte1.setNumeroCompte(44552211);
	     compte1.setIban("FR12124545");
	     compte1.setStartDate(LocalDate.of(2018,02,10));
	     compte1.setEndDate(LocalDate.of(2021,02,10));
	     Set<Carte> cartes = new HashSet<Carte>();
	     cartes.add(carte1);
		 compte1.setCartes(cartes);
		 
		Client client = new Client();
		  client.setId(1L);
		  client.setLogin("ramzi80");
		  client.setPassword("0000");
		  client.setFirstName("ramzi");
		  client.setLastName("ouertani");
		  Set<Compte> comptes = new HashSet<Compte>();
		     comptes.add(compte1);
		  client.setComptes(comptes);
		  

		  
    	
    	//when
    	clientRepo.save(client);    
    	//clientRepo.flush();
    	//Client getClient = clientRepo.getClientByNumCarte(147258);
		TypedQuery<Client> query = entityManager.createQuery("select c from Client c left join fetch c.comptes p left join fetch p.cartes b", Client.class);
		//TypedQuery<Client> result = query.setParameter("numcarte", 147258);
		List<Client> client1 = query.getResultList();
		  
		//then
		assertThat(client1).extracting("password").containsOnly("0000");
    	
    	   	
        //Assert.assertEquals(savedClient.getLogin(), getClient.getLogin());
    	
    	
    	
    }


}
