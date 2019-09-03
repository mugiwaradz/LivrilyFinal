package com.zinou.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.Client;
import com.zinou.springboot.web.service.ClientService;
import com.zinou.springboot.web.service.UtilisateureService;;

@Controller
public class ClientController {

	@Autowired
	ClientService service;

	@Autowired
	UtilisateureService utilisateureService;

	@GetMapping("Client/{client_id}")
	Client getClient(@PathVariable("client_id") int client_id) {
		return service.getClient(client_id);
	}

	@PostMapping("InscrClient")
	String inscrClient(@RequestParam int utilisateur_id, @RequestParam int numCartCredit, @RequestParam String longitude, @RequestParam String latitude) {
		service.inscrClient(utilisateur_id, numCartCredit,latitude, longitude);
		return "redirect:/welcomeClient";
	}

	@GetMapping("/InscrClient")
	String Client(@RequestParam int utilisateur_id) {
		return "InscrClient";
	}

	@GetMapping("/welcomeClient")
	String welcomeClient() {
		return "welcomeClient";

	}

	@RequestMapping(value = "/Clients", method = RequestMethod.GET)
	String getClients(@RequestParam(required = false) String id_client, ModelMap model) {

		int id = id_client == null || id_client.length() == 0 ? 0 : Integer.parseInt(id_client);
		int type_user = 1;
		model.put("Clients", utilisateureService.getutilisateurs(type_user, id));

		return "Clients";
	}
	
	
	
	@RequestMapping(value = "/Profile", method = RequestMethod.GET)
	String getProfile(@RequestParam(required = false) String user_id, ModelMap model) {

		int id = Integer.parseInt(user_id);
		int type_user = 1;
		model.put("Clients", utilisateureService.getutilisateurs(type_user, id).get(0));

		return "Profile";
	}

}
