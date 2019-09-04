package com.zinou.springboot.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping("login")
	String Login(@RequestParam String login, @RequestParam String password) {

		Map<String, Object> resulMap = service.Login(login, password);
		String type = (String) resulMap.get("type");
		int user_id = (Integer) resulMap.get("user_id");
		int id = (Integer) resulMap.get("id");
		if (user_id <= 0)
			return "redirect:/Inscrire";

		switch (type) {
		case "C":
			return "redirect:/welcomeClient?user_id="+user_id+"&client_id=" + id;
		case "ADF":
			return "redirect:/welcomeADF?user_id="+user_id+"&adf_id="+id ;
		case "F":
			return "redirect:/welcomeFournisseur?user_id="+user_id+"&fournisseur_id="+id ;
		case "L":
			return "redirect:/welcomeLivreur?user_id="+user_id+"&livreur_id="+id ;
		case "ADS":
			return "redirect:/welcomeADS?user_id="+user_id+"&ads_id="+id ;
		default:
			return "redirect:/";
		}
	}
}
