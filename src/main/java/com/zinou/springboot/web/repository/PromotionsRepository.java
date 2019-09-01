package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.model.Produit;

@Repository
public interface PromotionsRepository {



	int postPromotion(int promotion, int produit_ID);

	List<Produit> getPromotion(int categorieProduit_ID);

}
