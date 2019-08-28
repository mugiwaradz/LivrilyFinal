package com.zinou.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Utilisateur;
import com.zinou.springboot.web.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository repository;

	@Override
	public boolean Login(Utilisateur utilisateur) {

		return repository.Login(utilisateur.getLogin(),utilisateur.getPasword());

	}

}
