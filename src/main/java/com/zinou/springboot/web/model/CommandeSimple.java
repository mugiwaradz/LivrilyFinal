package com.zinou.springboot.web.model;

public class CommandeSimple {

	private int produit_id;
	private int qtyCommande;
	private int client_id;
	private int superMarche_id;

	
	
	
	public CommandeSimple(int produit_id, int qtyCommande, int client_id, int superMarche_id) {
		super();
		this.produit_id = produit_id;
		this.qtyCommande = qtyCommande;
		this.client_id = client_id;
		this.superMarche_id = superMarche_id;
	}

	public CommandeSimple() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProduit_id() {
		return produit_id;
	}

	public void setProduit_id(int produit_id) {
		this.produit_id = produit_id;
	}

	public int getQtyCommande() {
		return qtyCommande;
	}

	public void setQtyCommande(int qtyCommande) {
		this.qtyCommande = qtyCommande;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getSuperMarche_id() {
		return superMarche_id;
	}

	public void setSuperMarche_id(int superMarche_id) {
		this.superMarche_id = superMarche_id;
	}

}
