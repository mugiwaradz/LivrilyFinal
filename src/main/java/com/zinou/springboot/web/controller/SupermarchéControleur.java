package com.zinou.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zinou.springboot.web.model.Supermarché;
import com.zinou.springboot.web.service.SupermarchéService;


@RestController
public class SupermarchéControleur {
	
	@Autowired
	SupermarchéService service;
	
	@PostMapping("Supermarche")
	Supermarché AjouterSupermarché(@RequestBody Supermarché supermarché){
		return service.AjouterSupermarché(supermarché);
	}

	@DeleteMapping("Supermarche/{id_supermarche}")
	boolean SupprimerSupermarché(@PathVariable("id_supermarche") int id_Supermarché){
		return service.suprimerSupermarché(id_Supermarché);
	}

}
