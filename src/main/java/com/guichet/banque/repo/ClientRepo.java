package com.guichet.banque.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guichet.banque.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long>{
	
	@Query(value = "select c from Client c where c.login = ?1")
	public Client getClientByLogin(String Login);
	
	@Query(value =  "select c from Client c left join fetch c.comptes p left join fetch p.cartes b where b.numeroCarte = ?1")
	public Client getClientByNumCarte(Integer numero);
}
