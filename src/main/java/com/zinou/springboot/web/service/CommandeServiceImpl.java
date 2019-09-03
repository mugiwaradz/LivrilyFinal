package com.zinou.springboot.web.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Client;
import com.zinou.springboot.web.model.Commande;
import com.zinou.springboot.web.model.CommandeLine;
import com.zinou.springboot.web.model.CommandeSimple;
import com.zinou.springboot.web.model.Commandecomplette;
import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.repository.ArticleRepositoryImpl;
import com.zinou.springboot.web.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {

	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Autowired
	CommandeRepository repository;

	@Autowired
	ClientService clientService;

	@Autowired
	ArticleService articleService;

	@Override
	public List<Commandecomplette> getCommandes(int id_commande) {
		return repository.getCommandes(id_commande);
	}

	@Override
	public Commandecomplette createCommandes(List<CommandeSimple> commandes) {

		Client client = clientService.getClient(commandes.get(0).getClient_id());

		Commandecomplette commandeComplete = new Commandecomplette();
		Commande commande = new Commande();
		commande.setClinet_ID(client.getClient_ID());
		commande.setDtaedeCommande(new Timestamp(System.currentTimeMillis()));
		commande.setStatue("Non Livrer");
		commande.setSupermarché_ID(commandes.get(0).getSuperMarche_id());
		commande.setTarif(client.getTarif());
		commande.setTva(17);

		commandeComplete.setCommande(commande);

		commande = repository.saveCommande(commande);

		Double prixTotal = 0.0;

		List<CommandeLine> lines = new ArrayList<>();

		for (CommandeSimple c : commandes) {
			int produit_id = c.getProduit_id();

			FullProduit produit = articleService.getProduit(produit_id);
			CommandeLine line = new CommandeLine();
			line.setCommande_ID(commande.getCommande_ID());
			line.setPrix(produit.getPrixDevante());
			line.setProduit_ID(produit.getProduit_ID());
			line.setQuantityCommande(c.getQtyCommande());
			line.setTotalLine(line.getQuantityCommande() * line.getPrix());
			prixTotal = prixTotal + line.getTotalLine();

			line = repository.saveCommandeLine(line);

			lines.add(line);

		}

		commandeComplete.setCommandelines(lines);

		repository.updateCommande(prixTotal, commande.getCommande_ID(), "Commande_" + commande.getCommande_ID());
		commande.setTotal(prixTotal);
		return commandeComplete;
	}

}
