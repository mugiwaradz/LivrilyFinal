package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Commande;
import com.zinou.springboot.web.model.CommandeLine;
import com.zinou.springboot.web.model.Commandecomplette;

@Repository
public interface CommandeRepository {

	List<Commandecomplette> getCommandes(int id_commande,String statue);

	CommandeLine saveCommandeLine(CommandeLine line);

	void updateCommande(Double prixTotal, int commande_ID, String numeroCommande);

	Commande saveCommande(Commande commande);

	List<Commandecomplette> getCommandes(String client_id);

}
