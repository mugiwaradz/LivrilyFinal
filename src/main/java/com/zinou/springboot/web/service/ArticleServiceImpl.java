package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository repository;

	@Override
	public FullProduit getProduit(int id_article) {
		return repository.getProduit(id_article);
	}

	@Override
	public Produit createProduits(Produit produit) {
		return repository.createProduits(produit);
	}

	@Override
	public boolean deleteProduits(int id_article) {
		return repository.deleteProduits(id_article);
	}

	@Override
	public List<FullProduit> getProduits() {
		return repository.getProduits();
	}
}
