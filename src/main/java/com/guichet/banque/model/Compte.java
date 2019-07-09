package com.guichet.banque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.Reference;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="numero_compte",unique = true , nullable = false)
	private Integer numeroCompte;
	
	@Column(name="iban",unique = true , nullable = false)
	private String iban;
	
	//@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name="start_date", nullable = false)
	private LocalDate startDate;
	
	//@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name="end_date", nullable = false)
	private LocalDate endDate;
	
	@Column(name="montant")
	private Double montant;
	
	@Column(name="date_transaction")
	private LocalDate dateTransaction;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "compte", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<Carte> cartes = new HashSet<Carte>();
	
	public Compte() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Integer numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@JsonBackReference
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
    @JsonManagedReference
	public Set<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(Set<Carte> cartes) {
		this.cartes = cartes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, endDate, iban, id, numeroCompte, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Compte)) {
			return false;
		}
		Compte other = (Compte) obj;
		return Objects.equals(client, other.client) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(iban, other.iban) && Objects.equals(id, other.id)
				&& Objects.equals(numeroCompte, other.numeroCompte) && Objects.equals(startDate, other.startDate);
	}
	
	

}
