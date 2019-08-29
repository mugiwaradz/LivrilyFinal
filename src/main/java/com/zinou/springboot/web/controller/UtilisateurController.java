package com.zinou.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.Full_User;
import com.zinou.springboot.web.service.UtilisateureService;

@Controller
public class UtilisateurController {

	@Autowired
	UtilisateureService service ;


	@GetMapping("Utilisateur")
	List<Full_User> getUtilisateurs(@RequestParam int type_user, @RequestParam(required = false) String id_utilisateur){
		return service.getutilisateurs(type_user,
				(id_utilisateur != null && id_utilisateur.length() > 0) ? Integer.parseInt(id_utilisateur) : -1);
	}
	
	@RequestMapping(value = "/Clients", method = RequestMethod.GET)
	String getClients(@RequestParam(required = false) String id_client, ModelMap model) {

		int id = id_client == null || id_client.length() == 0 ? 0 : Integer.parseInt(id_client);
		int type_user=1;
		model.put("Clients", service.getutilisateurs(type_user, id));

		return "Clients";
	}
	
//	@RequestMapping(value = "/Commandes", method = RequestMethod.GET)
//	String getCommandes(@RequestParam(required = false) String id_commande, ModelMap model) {
//
//		int id = id_commande == null || id_commande.length() == 0 ? 0 : Integer.parseInt(id_commande);
//		model.put("orders", service.getCommandes(id));
//
//		return "Commandes";
//	}
//	
//	@RequestMapping(value = "/Commandes", method = RequestMethod.GET)
//	String getCommandes(@RequestParam(required = false) String id_commande, ModelMap model) {
//
//		int id = id_commande == null || id_commande.length() == 0 ? 0 : Integer.parseInt(id_commande);
//		model.put("orders", service.getCommandes(id));
//
//		return "Commandes";
//	}
//	
	
	
	
	
	
	
	
	@PostMapping("Utilisateur")
	Full_User createUtilisateurs(@RequestBody Full_User full_user){
		return service.createutilisateurs(full_user);
	}

	@DeleteMapping("Utilisateur/{id_utilisateur}")
	boolean deleteUtilisateurs(@PathVariable("id_utilisateur") int id_utilisateur){
		return service.deleteUtilisateurs(id_utilisateur);
	}
}
