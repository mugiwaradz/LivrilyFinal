package com.zinou.springboot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	ArticleService service;
	
	@GetMapping("Article/{id_article}")
	FullProduit getArticles(@PathVariable( "id_article") int id_article){
		return service.getProduit(id_article);
	}

	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	String getArticles(ModelMap model){
		List<FullProduit> articles = service.getProduits();
		model.put("produits", articles);
		return "articles";
	}
	
	@RequestMapping(value = "/Comandearticles", method = RequestMethod.GET)
	String getCommandeArticles(ModelMap model){
		List<FullProduit> articles = service.getProduits();
		model.put("produits", articles);
		return "Comandearticles";
	}
	

	@RequestMapping(value = "/Nosarticles", method = RequestMethod.GET)
	String getNosarticles(ModelMap model){
		List<FullProduit> articles = service.getProduits();
		model.put("produits", articles);
		return "Nosarticles";
	}
	
	
	@RequestMapping(value = "/add-Article", method = RequestMethod.GET)
	public String showAddArticlePage(ModelMap model) {
		model.addAttribute("Article", new Produit());
		return "Article";
	}
	
	@RequestMapping(value = "/add-Article", method = RequestMethod.POST)
	public String addArticle(ModelMap model, @Valid Produit article, BindingResult result) {

		if (result.hasErrors()) {
			return "Article";
		}

		service.createProduits(article);
				
		return "redirect:/articles";
	}
	
	@RequestMapping(value = "/delete-article", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {

		service.deleteProduits(id);
		return "redirect:/articles";
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
