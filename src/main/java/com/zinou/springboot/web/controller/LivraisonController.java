package com.zinou.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.springboot.web.model.Livraisoncomplette;
import com.zinou.springboot.web.service.LivraisonService;

@RestController
public class LivraisonController {

	@Autowired
	LivraisonService service ;

	@GetMapping("Livraisons")
	List<Livraisoncomplette> getLivraisons(@RequestParam(required = false) Boolean estlivre, @RequestParam(required = false) int livraison_id){
		return service.getLivraisons(estlivre, livraison_id);
	}
	@PostMapping("Livraisons")
	boolean createLivraison(@RequestParam int id_commande,@RequestParam int livreur_id){
		return service.createLivraison(id_commande, livreur_id);
	}
	

}
