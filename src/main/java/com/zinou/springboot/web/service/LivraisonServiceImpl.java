package com.zinou.springboot.web.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.CommandeLine;
import com.zinou.springboot.web.model.Commandecomplette;
import com.zinou.springboot.web.model.Livraison;
import com.zinou.springboot.web.model.Livraison_Line;
import com.zinou.springboot.web.model.Livraisoncomplette;
import com.zinou.springboot.web.repository.LivraisonRepository;

@Service
public class LivraisonServiceImpl implements LivraisonService{

	@Autowired
	LivraisonRepository repository;
	@Autowired
	CommandeService commandeservice;

	@Override
	public List<Livraisoncomplette> getLivraisons(Boolean estlivre, int livraison_id) {
		if(livraison_id > 0)
			return Arrays.asList(repository.getLivraisonByID(livraison_id));
		else
			return repository.getLivraisons(estlivre);
			
	}

	@Override
	public boolean createLivraison(int id_commande, int livreur_id) {

		Commandecomplette commande= commandeservice.getCommandes(id_commande).get(0);
		Livraison livraison = new Livraison();
		livraison.setCommande_ID(commande.getCommande().getCommande_ID());
		livraison.setNumeroLivraison("Ship_" + commande.getCommande().getNumeroCommande());
		livraison.setEstLivre(false);
		livraison.setLivreur_ID(livreur_id);
		
		livraison = repository.createLivraison(livraison);

		Double volumneTotal = 0.0;
		
		for (CommandeLine line : commande.getCommandelines()) {
			Livraison_Line lLine = new Livraison_Line();
			lLine.setLivraison_ID(livraison.getLivraison_ID());
			lLine.setProduit_ID(line.getProduit_ID());
			lLine.setQuantitylivre(line.getQuantityCommande());
			lLine.setVolume(0.0);//TODO : volumne depuis article
			lLine = repository.createLivraisonLine(lLine);
			volumneTotal = volumneTotal + lLine.getVolume();
		}
		
		repository.updateLivraison(volumneTotal, livraison.getLivraison_ID());

		return true;
	}

}