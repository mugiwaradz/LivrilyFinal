package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Livraison;
import com.zinou.springboot.web.model.Livraison_Line;
import com.zinou.springboot.web.model.Livraisoncomplette;

@Repository
public interface LivraisonRepository {

	List<Livraisoncomplette> getLivraisons(Boolean estlivre);

	Livraisoncomplette getLivraisonByID(int livraison_id);

	Livraison createLivraison(Livraison livraison);

	Livraison_Line createLivraisonLine(Livraison_Line line);

	void updateLivraison(Double volumneTotal, int livraison_id);

	boolean ValiderLivraison(int id);

	void updateCommande(int commmande_id);

}
