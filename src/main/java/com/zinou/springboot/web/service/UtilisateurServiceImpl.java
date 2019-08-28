package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Full_User;
import com.zinou.springboot.web.repository.UtilisateurRepository;
import com.zinou.springboot.web.util.ExacteUser;

@Service
public class UtilisateurServiceImpl implements UtilisateureService {

	@Autowired
	UtilisateurRepository repository;

	@Override
	public List<Full_User> getutilisateurs(int type_user, int id_utilisateur) {

		String sql = null;

		switch (type_user) {
		case 1: sql=ExacteUser.GetClient();
		break;

		case 2: sql= ExacteUser.GetLivreur();
		break;

		case 3: sql=ExacteUser.GetFournisseur();
		break;

		default:
			sql=ExacteUser.GetUtilisateur();
		}

		if(id_utilisateur > 0)
			sql = sql  + " AND utilisateur.utilisateur_id = " + id_utilisateur;

		return repository.getUtilsateurs(type_user, sql);
	}


	@Override
	public boolean deleteUtilisateurs(int id_utilisateur) {
		return repository.deleteutilisateurs(id_utilisateur);

	}

	@Override
	public Full_User createutilisateurs(Full_User full_user) {
		return repository.createutilisateurs( full_user);

	}


}
