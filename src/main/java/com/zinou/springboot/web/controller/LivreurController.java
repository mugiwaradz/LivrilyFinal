package com.zinou.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.service.LivreurService;
import com.zinou.springboot.web.service.UtilisateureService;;

@Controller
public class LivreurController {

	@Autowired
	LivreurService service;

	@Autowired
	UtilisateureService utilisateureService;

	@GetMapping("/welcomeLivreur")
	String welcomeL() {
		return "welcomeLivreur";
	}

	@RequestMapping(value = "/Livreurs", method = RequestMethod.GET)
	String getLivreurs(@RequestParam(required = false) String id_livruer, ModelMap model) {

		int id = id_livruer == null || id_livruer.length() == 0 ? 0 : Integer.parseInt(id_livruer);
		int type_user = 2;

		model.put("Livreurs", utilisateureService.getutilisateurs(type_user, id));

		return "Livreurs";
	}
	@RequestMapping(value = "/Listeivreurs", method = RequestMethod.GET)
	String getListelivreurs( ModelMap model) {

        boolean est_disponible=true;
		model.put("Livreurs", utilisateureService.getLivreur(est_disponible));

		return "Listeivreurs";
	}

	@PostMapping("InscrLivreur")
	String inscrClient(@RequestParam int utilisateur_id, @RequestParam String moyenLivraison,
			@RequestParam String typePermetConduire, @RequestParam int distanceMax) {
		int livreur_id = service.inscrLivreur(utilisateur_id, moyenLivraison, typePermetConduire, distanceMax);
		return "redirect:/welcomeLivreur?user_id="+utilisateur_id+"&livreur_id="+livreur_id ;
	}

	@GetMapping("/InscrLivreur")
	String Client(@RequestParam int utilisateur_id) {
		return "InscrLivreur";
	}

}
