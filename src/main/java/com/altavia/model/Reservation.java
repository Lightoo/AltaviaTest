package com.altavia.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long idReservation;
	
	
	private LocalDate date;
	
	@Min(0)
	@Max(23)
	private int heureDebut;
	
	@Min(1)
	@Max(24)
	private int nombreHeures;
	
	@JsonIgnore
	@Min(8)
	private float prixTotal;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idTerrain", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Terrain terrain;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idEquipe", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Equipe equipe;
	
	public Reservation() {
		
	}

	public Reservation(LocalDate date, int heureDebut, int nombreHeures, float prixTotal, Terrain terrain, Equipe equipe) {
		super();
		this.date = date;
		this.heureDebut = heureDebut;
		this.nombreHeures = nombreHeures;
		this.prixTotal = prixTotal;
		this.terrain = terrain;
		this.equipe = equipe;
	}

	
	
	
}
