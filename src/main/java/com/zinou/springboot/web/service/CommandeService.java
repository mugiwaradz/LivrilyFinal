package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.CommandeSimple;
import com.zinou.springboot.web.model.Commandecomplette;

@Service
public interface CommandeService {

	List<Commandecomplette> getCommandes( int commande_id);
	
	Commandecomplette createCommandes(List<CommandeSimple> commandes);
	
}
