package com.zinou.springboot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.Full_User;
import com.zinou.springboot.web.model.Utilisateur;
import com.zinou.springboot.web.service.UtilisateureService;

@Controller
public class UtilisateurController {

	@Autowired
	UtilisateureService service;

	@GetMapping("Utilisateur")
	List<Full_User> getUtilisateurs(@RequestParam int type_user,
			@RequestParam(required = false) String id_utilisateur) {
		return service.getutilisateurs(type_user,
				(id_utilisateur != null && id_utilisateur.length() > 0) ? Integer.parseInt(id_utilisateur) : -1);
	}

	@RequestMapping(value = "/Utilisateur", method = RequestMethod.POST)
	String createUtilisateurs(@Valid Utilisateur utilisateur) {

		utilisateur = service.createutilisateurs(utilisateur);
   
		switch (utilisateur.getType_user()) {
		case "F":
			return "redirect:/InscrFournisseur?utilisateur_id=" + utilisateur.getUtilisateur_ID();
		case "C":
			return "redirect:/InscrClient?utilisateur_id=" + utilisateur.getUtilisateur_ID();
		case "L":
			return "redirect:/InscrLivreur?utilisateur_id=" + utilisateur.getUtilisateur_ID();
		default:
			return "redirect:/Inscrire";
		}

	}

	@DeleteMapping("Utilisateur/{id_utilisateur}")
	boolean deleteUtilisateurs(@PathVariable("id_utilisateur") int id_utilisateur) {
		return service.deleteUtilisateurs(id_utilisateur);
	}

	@GetMapping("/welcomeADS")
	String welcomeADS() {
		return "welcomeADS";

	}

	@GetMapping("/welcomeADF")
	String welcomeADF() {
		return "welcomeADF";

	}

	@GetMapping("/Inscrire")
	String Inscrire() {
		return "Inscrire";

	}
	
	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {

		service.deleteUtilisateurs(id);
		return "redirect:/Clients";
	}

}
