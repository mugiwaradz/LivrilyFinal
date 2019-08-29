package com.zinou.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zinou.springboot.web.model.Utilisateur;
import com.zinou.springboot.web.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping("Login")
	boolean Login(@RequestBody Utilisateur utilisateur){
		return service.Login(utilisateur);
	}

}
