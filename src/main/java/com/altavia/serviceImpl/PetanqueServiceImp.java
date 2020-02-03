package com.altavia.serviceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.altavia.dao.EquipeRepository;
import com.altavia.dao.JoueurRepository;
import com.altavia.dao.ReservationRepository;
import com.altavia.model.Equipe;
import com.altavia.model.Joueur;
import com.altavia.model.Reservation;
import com.altavia.service.PetanqueService;
import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;

@Service
@Validated
public class PetanqueServiceImp implements PetanqueService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired 
	private JoueurRepository joueurRepository;
	@Autowired 
	private EquipeRepository equipeRepository;

	@Override
	public Joueur singup(Joueur joueur) {
		return joueurRepository.save(joueur);
	}

	@Override
	public List<Reservation> getReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Override
	public List<Reservation> getReservationsByDate(LocalDate date) {
		return reservationRepository.findByDate(date);
	}

	@Override
	public Equipe createEquipe(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@Override
	public Equipe getEquipeById(Long idEquipe) {
		return equipeRepository.findById(idEquipe).get();
	}

	@Override
	public Joueur getJoueurById(Long id) {
		return joueurRepository.findById(id).get();
	}

	@Override
	public Joueur updateJoueur(Joueur joueur) {
		return joueurRepository.save(joueur);
	}

	@Override
	public Reservation createReservation(Reservation reservation) {
		float prixTotal=0;
		float prixHeure=8;
		for(int i=0;i<reservation.getNombreHeures();i++) {
			prixTotal+=prixHeure;
			prixHeure=(float) (prixHeure*0.95);
		}
		reservation.setPrixTotal(prixTotal);
		YahooWeatherService service;
		try {
			//TODO
			service = new YahooWeatherService();
			Channel channel = service.getForecast("2502265", DegreeUnit.CELSIUS);
			System.out.println(channel.getDescription());
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		return reservationRepository.save(reservation);
	}

}
