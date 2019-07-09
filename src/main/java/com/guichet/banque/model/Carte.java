package com.guichet.banque.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="carte")
public class Carte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarte;
	
	@Column(name="proprietaire")
	private String proprietaire;
	
	@Column(name="numero_carte")
	private Integer numeroCarte;
	
	@Column(name="code_carte")
	private Integer codeCarte;
	
	@Column(name="date_expiration")
	private LocalDate dateExpiration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="compte_id")
	private Compte compte;
	
	
	public Carte() {
		
	}
	
	public Long getIdCarte() {
		return idCarte;
	}

	public void setIdCarte(Long idCarte) {
		this.idCarte = idCarte;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Integer getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(Integer numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public Integer getCodeCarte() {
		return codeCarte;
	}

	public void setCodeCarte(Integer codeCarte) {
		this.codeCarte = codeCarte;
	}

	public LocalDate getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	@JsonBackReference
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeCarte, compte, dateExpiration, idCarte, numeroCarte, proprietaire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Carte)) {
			return false;
		}
		Carte other = (Carte) obj;
		return Objects.equals(codeCarte, other.codeCarte) && Objects.equals(compte, other.compte)
				&& Objects.equals(dateExpiration, other.dateExpiration) && Objects.equals(idCarte, other.idCarte)
				&& Objects.equals(numeroCarte, other.numeroCarte) && Objects.equals(proprietaire, other.proprietaire);
	}
	
	
	
	

}
