package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Produit;

@Repository
public interface ArticleRepository {
	
	Produit getProduit(int id_article);
		
	Produit createProduits(Produit produit);
	
	boolean deleteProduits(int id_article);

	List<Produit> getProduits();



}
