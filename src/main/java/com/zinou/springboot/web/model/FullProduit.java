package com.zinou.springboot.web.model;

public class FullProduit {

	private int Produit_ID;
	private String NomProduit;
	private int CategoréProduit_ID;
	private Double PrixDachat;
	private Double PrixDevante;
	private int Fournisseur_ID;
	private String Image;
	private String Referance;
	private int promotion = 0;
	private int CtegoréProduit_ID;
	private String NomCategore;
	private String ImageCatégoré;
	private int quantite;

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantité) {
		this.quantite = quantité;
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

	public int getCategoréProduit_ID() {
		return CategoréProduit_ID;
	}

	public void setCategoréProduit_ID(int categoréProduit_ID) {
		CategoréProduit_ID = categoréProduit_ID;
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

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	public int getCtegoréProduit_ID() {
		return CtegoréProduit_ID;
	}

	public void setCtegoréProduit_ID(int ctegoréProduit_ID) {
		CtegoréProduit_ID = ctegoréProduit_ID;
	}

	public String getNomCategore() {
		return NomCategore;
	}

	public void setNomCategore(String nomCatégoré) {
		NomCategore = nomCatégoré;
	}

	public String getImageCatégoré() {
		return ImageCatégoré;
	}

	public void setImageCatégoré(String imageCatégoré) {
		ImageCatégoré = imageCatégoré;
	}

}
