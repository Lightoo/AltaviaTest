package com.altavia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.altavia.dao.JoueurRepository;
import com.altavia.model.Joueur;

@Service
public class CustomDetailsService implements UserDetailsService {
	@Autowired
	private JoueurRepository joueurRepository;

   @Override
   public CustomUser loadUserByUsername(final String login) throws UsernameNotFoundException {
      Joueur userEntity = null;
      try {
         userEntity = joueurRepository.findByLogin(login);
         CustomUser customUser = new CustomUser(userEntity);
         return customUser;
      } catch (Exception e) {
         e.printStackTrace();
         throw new UsernameNotFoundException("User " + login + " was not found in the database");
      }
   }
} 