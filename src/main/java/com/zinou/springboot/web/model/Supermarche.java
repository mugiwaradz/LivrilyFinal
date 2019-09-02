package com.zinou.springboot.web.model;

public class Supermarche {

	private int Supermarche_ID;
	private int Filiale_ID;
	private String NomSupermarche;
	private int TelephoneSupermarche;
	private String EmailSupermarche;
	private String Image_supermarche;

	public String getImage_supermarche() {
		return Image_supermarche;
	}

	public void setImage_supermarche(String image_supermarche) {
		Image_supermarche = image_supermarche;
	}

	public int getSupermarche_ID() {
		return Supermarche_ID;

	}

	public void setSupermarche_ID(int supermarché_ID) {
		Supermarche_ID = supermarché_ID;
	}

	public int getFiliale_ID() {
		return Filiale_ID;
	}

	public void setFiliale_ID(int filiale_ID) {
		Filiale_ID = filiale_ID;
	}

	public String getNomSupermarche() {
		return NomSupermarche;
	}

	public void setNomSupermarche(String nomSupermarche) {
		NomSupermarche = nomSupermarche;
	}

	public int getTelephoneSupermarche() {
		return TelephoneSupermarche;
	}

	public void setTelephoneSupermarche(int téléphoneSupermarché) {
		TelephoneSupermarche = téléphoneSupermarché;
	}

	public String getEmailSupermarche() {
		return EmailSupermarche;
	}

	public void setEmailSupermarche(String emailSupermarché) {
		EmailSupermarche = emailSupermarché;
	}

}
