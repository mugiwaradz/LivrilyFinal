package com.zinou.springboot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.model.Supermarche;
import com.zinou.springboot.web.service.SupermarchéService;

@Controller
public class SupermarcheControleur {

	@Autowired
	SupermarchéService service;

	@PostMapping("Supermarche")
	Supermarche AjouterSupermarché(@RequestBody Supermarche supermarché) {
		return service.AjouterSupermarché(supermarché);
	}
	
	
	@RequestMapping(value = "/supermarches", method = RequestMethod.GET)
	String getCommandeArticles(ModelMap model) {
		List<Supermarche> supermarches = service.getSupermarches();
		model.put("markets", supermarches);
		return "supermarches";
	}

	@RequestMapping(value = "/add-Supermarche", method = RequestMethod.GET)
	public String showAddArticlePage(ModelMap model) {
		model.addAttribute("Supermarche", new Supermarche());
		return "Supermarche";
	}

	@RequestMapping(value = "/add-Supermarche", method = RequestMethod.POST)
	public String addSupermarche(ModelMap model, @Valid Supermarche supermarche, BindingResult result) {

		if (result.hasErrors()) {
			return "Supermarche";
		}

		service.AjouterSupermarché(supermarche);

		return "redirect:/welcomeADF";
	}

	@RequestMapping(value = "/delete-Supermarche", method = RequestMethod.GET)
	public String deleteSupermarche(@RequestParam int id) {

		service.suprimerSupermarché(id);
		return "redirect:/";
	}

	@DeleteMapping("Supermarche/{id_supermarche}")
	boolean SupprimerSupermarché(@PathVariable("id_supermarche") int id_Supermarché) {
		return service.suprimerSupermarché(id_Supermarché);
	}

}
