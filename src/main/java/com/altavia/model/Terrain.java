package com.altavia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Terrain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTerrain;
	private String libelle;
	private String description;
	private String type;
	
	public Terrain() {
		
	}
	
	public Terrain(String libelle, String description, String type) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.type = type;
	}

	
}
