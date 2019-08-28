package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Produit;

@Service
public interface ArticleService {
	
	Produit getProduit(int id_article);
	
	List<Produit> getProduits();
	
	Produit createProduits(Produit produit);
	
	boolean deleteProduits(int id_article);

}
