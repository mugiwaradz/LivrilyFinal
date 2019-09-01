package com.zinou.springboot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.service.LivraisonService;

@Controller
public class LivraisonController {

	@Autowired
	LivraisonService service ;

	@RequestMapping(value = "/Livraisons", method = RequestMethod.GET)
	String getLivraisons(@RequestParam(required = false) Boolean estlivre, @RequestParam(required = false)  String id_livraison, ModelMap model){

		int id = id_livraison == null || id_livraison.length() == 0 ? 0 : Integer.parseInt(id_livraison);
		estlivre=true;
		model.put("shipments", service.getLivraisons(estlivre, id));

		return "Livraisons";

	}
	@RequestMapping(value = "/LivraisonDetail", method = RequestMethod.GET)
	String getLivraisonDetail(@RequestParam(required = false) Boolean estlivre, @RequestParam(required = false)  String id_livraison, ModelMap model) {
		estlivre=true;

		int id= Integer.parseInt(id_livraison);
		model.put("shipment", service.getLivraisons(estlivre, id).get(0));

		return "LivraisonDetail";
	}
	
	
	
	
	@PostMapping("Livraisons")
	boolean createLivraison(@RequestParam int id_commande,@RequestParam int livreur_id){
		return service.createLivraison(id_commande, livreur_id);
	}


}
