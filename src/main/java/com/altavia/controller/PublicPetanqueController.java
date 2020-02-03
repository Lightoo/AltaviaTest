package com.altavia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altavia.dao.JoueurRepository;
import com.altavia.model.Joueur;
import com.altavia.service.PetanqueService;

@RestController
public class PublicPetanqueController {
	@Autowired
	private PetanqueService petanqueService;
	
	@Autowired 
	private JoueurRepository joueurRepository;

	@GetMapping("/test")
	public List<Joueur> test() {
		return (List<Joueur>) joueurRepository.findAll();
	}
	
	@PostMapping("/singup")
	public Joueur singup(@RequestBody Joueur joueur) {
		PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
		joueur.setPassword(passwordEncoder.encode(joueur.getPassword()));
		return petanqueService.singup(joueur);
	}
	
}
