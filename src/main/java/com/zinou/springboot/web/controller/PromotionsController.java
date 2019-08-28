package com.zinou.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.service.PromotionsService;

@RestController
public class PromotionsController {

	@Autowired
	PromotionsService service;

	@GetMapping("promotion")
	List<Produit> getPromotion(@RequestParam int categorie_produit_id){
		return service.getPromotion(categorie_produit_id);
				
	}


	@PostMapping("promotion")
	int PostPromotion(@RequestBody Produit produit){
		return service.PostPromotion(produit);
	}

}
