package com.zinou.springboot.web.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.CommandeSimple;
import com.zinou.springboot.web.model.Commandecomplette;

@Service
public interface CommandeService {

	List<Commandecomplette> getCommandes(Timestamp date_commande, int commande_id);
	
	Commandecomplette createCommandes(List<CommandeSimple> commandes);

	boolean sendMail(int user_id);

	
}
