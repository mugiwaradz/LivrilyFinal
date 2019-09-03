package com.zinou.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.service.LivraisonService;

@Controller
public class LivraisonController {

	@Autowired
	LivraisonService service;

	@RequestMapping(value = "/Livraisons", method = RequestMethod.GET)
	String getLivraisons(@RequestParam(required = false) Boolean estlivre,
			@RequestParam(required = false) String id_livraison, ModelMap model) {

		int id = id_livraison == null || id_livraison.length() == 0 ? 0 : Integer.parseInt(id_livraison);
		estlivre = false;
		model.put("shipments", service.getLivraisons(estlivre, id));

		return "Livraisons";

	}

	@RequestMapping(value = "/LivraisonDetail", method = RequestMethod.GET)
	String getLivraisonDetail(@RequestParam(required = false) Boolean estlivre,
			@RequestParam(required = false) String id_livraison, ModelMap model) {
		estlivre = false;

		int id = Integer.parseInt(id_livraison);
		model.put("shipment", service.getLivraisons(estlivre, id).get(0));

		return "LivraisonDetail";
	}

	@PostMapping("Livraisons")
	String createLivraison(@RequestParam int id_commande, @RequestParam int livreur_id) {
		service.createLivraison(id_commande, livreur_id);
		return "redirect:/Livraisons";
	}
	
	
	@RequestMapping(value = "/ValiderLivraison", method = RequestMethod.GET)
	public String Validerlivraison(@RequestParam int id_livraison) {

		service.ValiderLivraison(id_livraison);
		return "redirect:/ListeLivraisons";
	}
	
	@RequestMapping(value = "/ListeLivraisons", method = RequestMethod.GET)
	String ListeLivraisons(@RequestParam(required = false) Boolean estlivre,
			@RequestParam(required = false) String id_livraison, ModelMap model) {

		int id = id_livraison == null || id_livraison.length() == 0 ? 0 : Integer.parseInt(id_livraison);
		estlivre = false;
		model.put("shipments", service.getLivraisons(estlivre, id));

		return "ListeLivraisons";

	}
	
	
	@GetMapping("mail")
	boolean getCommandes(@RequestParam int client_id) {
		return service.sendMail(client_id);
	}

}
