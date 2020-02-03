package com.altavia.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idJoueur;
	
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@NotEmpty
	private String login;
	@NotEmpty
	private String password;
	
	private String role;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "idEquipe", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private Equipe equipe;

	public Joueur() {
		
	}

	public Joueur(@NotEmpty String nom, @NotEmpty String prenom, @NotEmpty String login, @NotEmpty String password,
			String role, Equipe equipe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.role = role;
		this.equipe = equipe;
	}

	
	
	
}
