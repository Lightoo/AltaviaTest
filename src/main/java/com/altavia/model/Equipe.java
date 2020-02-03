package com.altavia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEquipe;
	private String nom;
	
//	@OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "equipe")
//	@JsonIgnore
//	private Set<Joueur> joueurs = new HashSet<>();
	
	public Equipe() {
		
	}

	public Equipe(String nom) {
		super();
		this.nom = nom;
	}
	
	

}
