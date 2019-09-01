package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.CommandeLine;
import com.zinou.springboot.web.model.Commandecomplette;
import com.zinou.springboot.web.model.Facture;
import com.zinou.springboot.web.model.FactureLine;
import com.zinou.springboot.web.model.Facturecomplette;
import com.zinou.springboot.web.model.Livraisoncomplette;
import com.zinou.springboot.web.repository.FactureRepository;


@Service
public class FactureServiceImpl implements FactureService{

	@Autowired
	FactureRepository repository;
	@Autowired
	LivraisonService livraisonService;
	@Autowired
	CommandeService commandeService;


	@Override
	public List<Facturecomplette> getFactures(int id_facture) {
		return repository.getFactures(id_facture);
	}

	@Override
	public boolean createFacture(int id_livraison) {

		Livraisoncomplette livraison = livraisonService.getLivraisons(null, id_livraison).get(0);
		Commandecomplette commande = commandeService.getCommandes(livraison.getLivraison().getCommande_ID()).get(0);

		Facture facture = new Facture();
		facture.setLivraison_ID(livraison.getLivraison().getLivraison_ID());
		String numeroComande = livraison.getLivraison().getNumeroLivraison().replace("Ship_", "");
		numeroComande = "Fact_" + numeroComande;
		facture.setNumeroFacture(numeroComande );
		facture.setClient_ID(commande.getCommande().getClinet_ID());
		facture.setTarif(commande.getCommande().getTarif());
		facture.setTva(commande.getCommande().getTva());

		facture = repository.createFacture(facture);


		Double total = 0.0;

		for (CommandeLine line : commande.getCommandelines()) {
			FactureLine fLine = new FactureLine();
			fLine.setFacture_ID(facture.getFacture_ID());
			fLine.setProduitID(line.getProduit_ID());
			fLine.setQuantityFacture(line.getQuantityCommande());
			fLine.setPrix(line.getPrix());
			fLine.setTotalLine(line.getTotalLine());
			fLine = repository.createFactureLine(fLine);
			total = total + fLine.getTotalLine();
		}

		repository.updateFacture(total, facture.getFacture_ID());

		return true;
	}

	@Override
	public ResponseEntity<Resource> printFacture(int id_facture) {
		return repository.printFacture(id_facture);
	}

}