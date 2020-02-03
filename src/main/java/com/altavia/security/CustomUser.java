package com.altavia.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;

import com.altavia.model.Joueur;

public class CustomUser extends User {
	   private static final long serialVersionUID = 1L;
	   public CustomUser(Joueur joueur) {
	      super(joueur.getLogin(), joueur.getPassword(), new ArrayList() {{add(joueur.getRole());}});
	   }
	} 
