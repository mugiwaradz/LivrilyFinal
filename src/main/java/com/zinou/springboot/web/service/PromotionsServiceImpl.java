package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.repository.PromotionsRepository;

@Service
public class PromotionsServiceImpl implements PromotionsService {

	@Autowired
	PromotionsRepository repository;

	@Override
	public int PostPromotion(Produit produit) {
		return repository.postPromotion(produit.getPromotion(), produit.getProduit_ID());
	}

	@Override
	public List<Produit> getPromotion(int categorieProduit_ID) {
		return repository.getPromotion(categorieProduit_ID);
	}

}
