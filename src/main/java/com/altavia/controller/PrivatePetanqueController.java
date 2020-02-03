package com.altavia.controller;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altavia.model.Equipe;
import com.altavia.model.Reservation;
import com.altavia.service.PetanqueService;

@RestController
@RequestMapping("/api")
public class PrivatePetanqueController {
	@Autowired
	private PetanqueService petanqueService;

	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/reservations")
	public List<Reservation> getReservationsByDate(@RequestParam(value="date",required=false) 
    				@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		if(date==null) {
			return petanqueService.getReservations();
		}else {
		return petanqueService.getReservationsByDate(date);
		}
	}
	
	@PostMapping("/equipes")
	public Equipe createEquipe(@RequestBody Equipe equipe) {
		return petanqueService.createEquipe(equipe);
	}
	
	@PutMapping("/equipes/{idEquipe}")
	public Equipe updateEquipe(@PathVariable Long idEquipe, @RequestParam(value = "idJoueur") List<Long> joueurs) {
		System.out.println(joueurs);
		Equipe equipe = petanqueService.getEquipeById(idEquipe);
		// joueurs.forEach(idJoueur ->{
		// equipe.getJoueurs().add(petanqueService.getJoueurById((Long) idJoueur));
		// });
		// return petanqueService.createEquipe(equipe);
		joueurs.forEach(idJoueur -> {
			petanqueService.updateJoueur(petanqueService.getJoueurById((Long) idJoueur));
		});
		return equipe;
	}
	
	
	@PostMapping("/reservations")
	public Reservation createReservation(@RequestBody Reservation reservation) {
		return petanqueService.createReservation(reservation);
	}
	
}
