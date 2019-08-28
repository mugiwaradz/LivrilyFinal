package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Full_User;

@Service
public interface UtilisateureService {

	List<Full_User> getutilisateurs(int type_user, int id_utilisateur);

	Full_User createutilisateurs(Full_User full_user);

	boolean deleteUtilisateurs(int id_utilisateur);

}
