package com.zinou.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
	CommandeService service ;

	@RequestMapping(value = "/Commandes", method = RequestMethod.GET)
	String getCommandes(@RequestParam(required = false) String id_commande, ModelMap model) {

		int id = id_commande == null || id_commande.length() == 0 ? 0 : Integer.parseInt(id_commande);
		model.put("orders", service.getCommandes(id));

		return "Commandes";
	}

	@PostMapping("Commandes")
	Commandecomplette getCommandes( @RequestBody List <CommandeSimple> commandes) {
		return service.createCommandes(commandes);
	}

	@GetMapping("mail")
	boolean getCommandes( @RequestParam int user_id) {
		return service.sendMail(user_id);
	}



}
