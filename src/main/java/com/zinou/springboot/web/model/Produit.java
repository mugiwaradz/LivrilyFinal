package com.zinou.springboot.web.model;

public class Produit {

	private int Produit_ID;
	private String NomProduit;
	private int CategoreProduit_ID;
	private Double PrixDachat;
	private Double PrixDevante;
	private int Fournisseur_ID;
	private String Image;
	private String Referance;
	private int quantite;
	private int superMarche_id;
	

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	private int promotion = 0;

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	public int getProduit_ID() {
		return Produit_ID;
	}

	public void setProduit_ID(int produit_ID) {
		Produit_ID = produit_ID;
	}

	public String getNomProduit() {
		return NomProduit;
	}

	public void setNomProduit(String nomProduit) {
		NomProduit = nomProduit;
	}

	public int getCategoreProduit_ID() {
		return CategoreProduit_ID;
	}

	public void setCategoreProduit_ID(int categoréProduit_ID) {
		CategoreProduit_ID = categoréProduit_ID;
	}

	public Double getPrixDachat() {
		return PrixDachat;
	}

	public void setPrixDachat(Double prixDachat) {
		PrixDachat = prixDachat;
	}

	public Double getPrixDevante() {
		return PrixDevante;
	}

	public void setPrixDevante(Double prixDevante) {
		PrixDevante = prixDevante;
	}

	public int getFournisseur_ID() {
		return Fournisseur_ID;
	}

	public void setFournisseur_ID(int fournisseur_ID) {
		Fournisseur_ID = fournisseur_ID;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getReferance() {
		return Referance;
	}

	public void setReferance(String referance) {
		Referance = referance;
	}

	public int getSuperMarche_id() {
		return superMarche_id;
	}

	public void setSuperMarche_id(int superMarche_id) {
		this.superMarche_id = superMarche_id;
	}

}
