package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Full_User;

@Repository
public interface UtilisateurRepository {
		
	List<Full_User> getUtilsateurs(int type_user, String sql);

	Full_User createutilisateurs(Full_User full_user);
	
	boolean deleteutilisateurs(int id_utilisateur);



}
