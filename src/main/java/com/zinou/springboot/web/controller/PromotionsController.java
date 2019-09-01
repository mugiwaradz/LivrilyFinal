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

import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.service.PromotionsService;

@Controller
public class PromotionsController {

	@Autowired
	PromotionsService service;

	@GetMapping("promotion")
	List<Produit> getPromotion(@RequestParam int categorie_produit_id){
		return service.getPromotion(categorie_produit_id);
				
	}

	@RequestMapping(value = "/Promotions", method = RequestMethod.GET)
	String getPromotions(@RequestParam(required = false) String id_categorie , ModelMap model){
		int id = id_categorie == null || id_categorie.length() == 0 ? 0 : Integer.parseInt(id_categorie);
		
		model.put("Promotions", service.getPromotion(id));
		return "Promotions";
	}
	
	

	@PostMapping("promotion")
	int PostPromotion(@RequestBody Produit produit){
		return service.PostPromotion(produit);
	}

}
