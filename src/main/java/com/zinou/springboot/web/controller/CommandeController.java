package com.zinou.springboot.web.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.CommandeSimple;
import com.zinou.springboot.web.model.Commandecomplette;
import com.zinou.springboot.web.service.CommandeService;

@Controller
public class CommandeController {

	@Autowired
	CommandeService service ;

	@GetMapping("Commandes")
	List<Commandecomplette> getCommandes( @RequestParam(required = false) Timestamp date_commande,
			@RequestParam(required = false) int id_commande) {
		return service.getCommandes(date_commande, id_commande);
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
