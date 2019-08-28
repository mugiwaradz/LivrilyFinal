package com.zinou.springboot.web.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Commande;
import com.zinou.springboot.web.model.CommandeLine;
import com.zinou.springboot.web.model.Commandecomplette;

@Repository
public interface CommandeRepository {

	List<Commandecomplette> getCommandes(Timestamp date_commande, int id_commande);

	CommandeLine saveCommandeLine(CommandeLine line);

	void updateCommande(Double prixTotal, int commande_ID);

	Commande saveCommande(Commande commande);
	
	


}
