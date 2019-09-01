package com.zinou.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.Client;
import com.zinou.springboot.web.service.ClientService;;

@Controller
public class ClientController {

	@Autowired
	ClientService service ;

	@GetMapping("Client/{client_id}")
	Client getClient(@PathVariable( "client_id") int client_id){
		return service.getClient(client_id);
	}

	
	@PostMapping("InscrClient")
	String inscrClient(@RequestParam int utilisateur_id, @RequestParam int numCartCredit){
		service.inscrClient(utilisateur_id, numCartCredit);
		return "redirect:/welcomeClient";
	}

	@GetMapping("/InscrClient")
	String Client(@RequestParam int utilisateur_id){
		return "InscrClient";
	}


}
