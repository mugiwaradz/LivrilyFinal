package com.zinou.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.CommandeSimple;
import com.zinou.springboot.web.model.Commandecomplette;
import com.zinou.springboot.web.service.CommandeService;

@Controller
public class CommandeController {

	@Autowired
	CommandeService service;

	@RequestMapping(value = "/Commandes", method = RequestMethod.GET)
	String getCommandes(@RequestParam(required = false) String id_commande, ModelMap model) {

		int id = id_commande == null || id_commande.length() == 0 ? 0 : Integer.parseInt(id_commande);
		model.put("orders", service.getCommandes(id));

		return "Commandes";
	}

	@RequestMapping(value = "/CommandeDetail", method = RequestMethod.GET)
	String getCommandesDetail(@RequestParam(required = false) String id_commande, ModelMap model) {

		int id = Integer.parseInt(id_commande);
		model.put("order", service.getCommandes(id).get(0));

		return "CommandeDetail";
	}

	@PostMapping("Commander")
	Commandecomplette getCommandes(@RequestBody List<CommandeSimple> commandes) {
		return service.createCommandes(commandes);
	}

}
