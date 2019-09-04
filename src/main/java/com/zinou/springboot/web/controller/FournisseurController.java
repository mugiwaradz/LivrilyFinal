package com.zinou.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.service.FournisseurService;
import com.zinou.springboot.web.service.UtilisateureService;;

@Controller
public class FournisseurController {

	@Autowired
	FournisseurService service;

	@Autowired
	UtilisateureService utilisateureService;

	@RequestMapping(value = "/Fournisseurs", method = RequestMethod.GET)
	String getFournisseurs(@RequestParam(required = false) String id_fournisseur, ModelMap model) {

		int id = id_fournisseur == null || id_fournisseur.length() == 0 ? 0 : Integer.parseInt(id_fournisseur);
		int type_user = 3;

		model.put("Fournisseurs", utilisateureService.getutilisateurs(type_user, id));

		return "Fournisseurs";
	}
	//

	@GetMapping("/welcomeFournisseur")
	String welcomeFournisseur() {
		return "welcomeFournisseur";

	}

	@PostMapping("InscrFournisseur")
	String inscrClient(@RequestParam int utilisateur_id, @RequestParam int numeroRegistre,
			@RequestParam int numeroFiscale, @RequestParam String taxId) {
		int fournisseur_id = service.inscrFournisseur(utilisateur_id, numeroRegistre, numeroFiscale, taxId);
		return "redirect:/welcomeFournisseur?user_id="+utilisateur_id+"&fournisseur_id="+fournisseur_id ;
	}

	@GetMapping("/InscrFournisseur")
	String Client(@RequestParam int utilisateur_id) {
		return "InscrFournisseur";
	}

}
