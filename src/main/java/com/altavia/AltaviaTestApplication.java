package com.altavia;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.altavia.dao.EquipeRepository;
import com.altavia.dao.JoueurRepository;
import com.altavia.dao.ReservationRepository;
import com.altavia.dao.TerrainRepository;
import com.altavia.model.Equipe;
import com.altavia.model.Joueur;
import com.altavia.model.Reservation;
import com.altavia.model.Terrain;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class AltaviaTestApplication implements CommandLineRunner {

	@Autowired
	private JoueurRepository joueurRepository;
	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private EquipeRepository equipeRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AltaviaTestApplication.class, args);
	}

	@Override
	public void run(String... args) {
		
		//équipes
		Equipe equipe1= equipeRepository.save(new Equipe("equipe1"));
		Equipe equipe2= equipeRepository.save(new Equipe("equipe2"));
		// joueurs
		PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
		joueurRepository.save(new Joueur("nom1", "prenom1", "login1", passwordEncoder.encode("password1"),"USER",equipe1));
		joueurRepository.save(new Joueur("nom2", "prenom2", "login2", passwordEncoder.encode("password2"),"USER",equipe1));
		joueurRepository.save(new Joueur("nom3", "prenom3", "login3", passwordEncoder.encode("password3"),"USER",equipe1));
		joueurRepository.save(new Joueur("nom4", "prenom4", "login4", passwordEncoder.encode("password4"),"USER",equipe2));
		joueurRepository.save(new Joueur("nom5", "prenom5", "login5", passwordEncoder.encode("password5"),"USER",equipe2));
		
		//terrains
		Terrain terrain1 = terrainRepository.save(new Terrain("Sol naturel", "Sol naturel à l’extérieur", "exterieur"));
		Terrain terrain2 = terrainRepository.save(new Terrain("Herbe", "Herbe à l’extérieur", "exterieur"));
		Terrain terrain3 = terrainRepository.save(new Terrain("bitume", "bitume à l’intérieur.", "interieur"));
		
		//reservations
		reservationRepository.save(new Reservation(LocalDate.of(2020, 2, 2), 10, 2, (float) (8+8*0.95), terrain1, equipe1));
		reservationRepository.save(new Reservation(LocalDate.of(2020, 2, 3), 14, 1, (float) 8, terrain3, equipe2));
		
		
	}
}
