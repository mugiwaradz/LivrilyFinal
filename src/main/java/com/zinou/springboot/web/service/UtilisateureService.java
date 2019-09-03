package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Full_User;
import com.zinou.springboot.web.model.Livreur;
import com.zinou.springboot.web.model.Utilisateur;

@Service
public interface UtilisateureService {

	List<Full_User> getutilisateurs(int type_user, int id_utilisateur);

	boolean deleteUtilisateurs(int id_utilisateur);

	Utilisateur createutilisateurs(Utilisateur utilisateur);


		List<Livreur> getLivreur(boolean est_disponible);

	

}
