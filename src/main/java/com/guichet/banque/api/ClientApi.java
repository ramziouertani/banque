package com.guichet.banque.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guichet.banque.model.Carte;
import com.guichet.banque.model.Client;
import com.guichet.banque.service.clientservice.ClientService;

@RestController
@RequestMapping("/api/v1/client")
public class ClientApi {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<List<Client>> getAllClient() {
		
		return new ResponseEntity<List<Client>>(clientService.getAllClient(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Client> addClient(@RequestBody Client client){
		
		return new ResponseEntity<Client>(clientService.addClient(client),HttpStatus.OK);
	}
	
	@GetMapping(value="/login")
	public ResponseEntity<Client> getClientByLogin(@RequestParam(name="login") String login){
		return new ResponseEntity<Client>(clientService.getClientByLogin(login),HttpStatus.OK);
	}
	
	@GetMapping(value="/carte")
	public ResponseEntity<Client> getClientByCarte(@RequestParam Integer numeroCarte){
		
		Carte carte = new Carte();
		carte.setNumeroCarte(numeroCarte);
		
		return new ResponseEntity<Client>(clientService.getClientByNumeroCarte(carte),HttpStatus.OK);
		
	}
	
	

}
