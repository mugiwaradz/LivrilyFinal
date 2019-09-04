package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.model.Produit;

@Service
public interface ArticleService {

	FullProduit getProduit(int id_article);

	List<FullProduit> getProduits();

	Produit createProduits(Produit produit);

	boolean deleteProduits(int id_article);

	List<FullProduit> getProduitsByNom(String nom);

}
