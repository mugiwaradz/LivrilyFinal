package com.zinou.springboot.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping("login")
	String Login(@RequestParam String login, @RequestParam String password){

		Map<String, Object> resulMap =  service.Login(login, password);
		String type = (String) resulMap.get("type");
		int user_id = (Integer) resulMap.get("user_id");
		if (user_id <= 0)
			return "redirect:/Inscrire";

		switch (type) {
		case "C":
			return "redirect:/welcomeClient";
		case "ADF":
			return "redirect:/welcomeADF";
		case "F":
			return "redirect:/welcomeFournisseur";
		case "L":
			return "redirect:/welcomeLivreur";
		case "ADS":
			return "redirect:/welcomeADS";
		default:
			return "redirect:/login";
		}
	}
}
