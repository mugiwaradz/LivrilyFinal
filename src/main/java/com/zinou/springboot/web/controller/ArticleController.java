package com.zinou.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService service;
	
	@GetMapping("Article/{id_article}")
	Produit getArticles(@PathVariable( "id_article") int id_article){
		return service.getProduit(id_article);
	}

	@GetMapping("Articles")
	List<Produit> getArticles(){
		return service.getProduits();
	}
	
	@PostMapping("Article")
	Produit createArticles(@RequestBody Produit produit){
		return service.createProduits(produit);
	}

	@DeleteMapping("Article/{id_article}")
	boolean deleteArticles(@PathVariable("id_article") int id_article){
		return service.deleteProduits(id_article);
	}

}
