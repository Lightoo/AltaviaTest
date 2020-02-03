package com.altavia.service;

import java.time.LocalDate;
import java.util.List;

import com.altavia.model.Equipe;
import com.altavia.model.Joueur;
import com.altavia.model.Reservation;

public interface PetanqueService {
	
	public Joueur singup(Joueur joueur);
	public Joueur getJoueurById(Long id);
	public Joueur updateJoueur(Joueur joueur);
	
	public Equipe createEquipe(Equipe equipe);
	public Equipe getEquipeById(Long idEquipe);
	public List<Reservation> getReservations();
	public List<Reservation> getReservationsByDate(LocalDate date);
	public Reservation createReservation(Reservation reservation);

}
