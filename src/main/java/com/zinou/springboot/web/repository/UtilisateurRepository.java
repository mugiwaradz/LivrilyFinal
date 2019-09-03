package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Full_User;
import com.zinou.springboot.web.model.Livreur;
import com.zinou.springboot.web.model.Utilisateur;

@Repository
public interface UtilisateurRepository {

	List<Full_User> getUtilsateurs(int type_user, String sql);

	boolean deleteutilisateurs(int id_utilisateur);

	Utilisateur createutilisateurs(Utilisateur utilisateur);

	List<Livreur> getLivreur(boolean est_disponible);

}
