package com.zinou.springboot.web.service;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Utilisateur;

@Service
public interface LoginService {

	boolean Login(Utilisateur utilisateur);

}
