package com.altavia.dao;

import org.springframework.data.repository.CrudRepository;

import com.altavia.model.Joueur;

public interface JoueurRepository extends CrudRepository<Joueur,Long>{

	Joueur findByLogin(String login);
}
