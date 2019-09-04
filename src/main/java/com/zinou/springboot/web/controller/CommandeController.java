package com.zinou.springboot.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.CommandeSimple;
import com.zinou.springboot.web.model.Commandecomplette;
import com.zinou.springboot.web.service.CommandeService;

@Controller
public class CommandeController {

	
	private static List<CommandeSimple> commandes = new ArrayList<>(); 
	@Autowired
	CommandeService service;

	@RequestMapping(value = "/Commandes", method = RequestMethod.GET)
	String getCommandes(@RequestParam(required = false) String id_commande, ModelMap model) {

		int id = id_commande == null || id_commande.length() == 0 ? 0 : Integer.parseInt(id_commande);
		model.put("orders", service.getCommandes(id, "Non Livrer"));

		return "Commandes";
	}

	@RequestMapping(value = "/CommandeDetail", method = RequestMethod.GET)
	String getCommandesDetail(@RequestParam(required = false) String id_commande, ModelMap model) {

		int id = Integer.parseInt(id_commande);
		model.put("order", service.getCommandes(id, "Non Livrer").get(0));

		return "CommandeDetail";
	}

	@PostMapping("Commander")
	String getCommandes() {
		service.createCommandes(commandes);
		commandes = new ArrayList<>();
		return "redirect:/welcomeClient";
	}

	@GetMapping("maCommande")
	String getCommandes(ModelMap map){
		map.put("commandes", commandes);
		return "redirect:/maCommande";
	}
	
	
	@PostMapping("add-panier")
	String getCommandes(@RequestParam int product_id, @RequestParam int qty, @RequestParam int client_id) {
		commandes.add(new CommandeSimple(product_id, qty, client_id, 1));
		return "redirect:/Comandearticles?client_id=" + client_id;
	}

}
