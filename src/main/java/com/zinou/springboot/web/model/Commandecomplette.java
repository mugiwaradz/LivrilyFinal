package com.zinou.springboot.web.model;

import java.util.ArrayList;
import java.util.List;

public class Commandecomplette {
	private Commande commande;
	private List<CommandeLine> commandelines = new ArrayList<>();
	private boolean estLivrer;
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<CommandeLine> getCommandelines() {
		return commandelines;
	}

	public void setCommandelines(List<CommandeLine> commandelines) {
		this.commandelines = commandelines;
	}

	public boolean isEstLivrer() {
		return estLivrer;
	}

	public void setEstLivrer(boolean estLivrer) {
		this.estLivrer = estLivrer;
	}

}
