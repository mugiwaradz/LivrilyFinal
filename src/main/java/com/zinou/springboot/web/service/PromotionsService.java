package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Produit;
@Service
public interface PromotionsService {

	

	int PostPromotion(Produit produit);

	List<Produit> getPromotion(int categorieProduit_ID);
	

}
