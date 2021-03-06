package com.zinou.springboot.web.model;

public class Client {

	private int Client_ID;
	private int Utilisateur_ID;
	private int NumCarteCredit;
	private String tarif;
	private boolean envoyerMail;
	private boolean envoyerSMS;
	private String latitude;
	private String longitude;

	public int getClient_ID() {
		return Client_ID;
	}

	public void setClient_ID(int client_ID) {
		Client_ID = client_ID;
	}

	public int getUtilisateur_ID() {
		return Utilisateur_ID;
	}

	public void setUtilisateur_ID(int utilisateur_ID) {
		Utilisateur_ID = utilisateur_ID;
	}

	public int getNumCarteCredit() {
		return NumCarteCredit;
	}

	public void setNumCarteCredit(int numCarteCredit) {
		NumCarteCredit = numCarteCredit;
	}

	public String getTarif() {
		return tarif;
	}

	public void setTarif(String tarif) {
		this.tarif = tarif;
	}

	public boolean isEnvoyerMail() {
		return envoyerMail;
	}

	public void setEnvoyerMail(boolean envoyerMail) {
		this.envoyerMail = envoyerMail;
	}

	public boolean isEnvoyerSMS() {
		return envoyerSMS;
	}

	public void setEnvoyerSMS(boolean envoyerSMS) {
		this.envoyerSMS = envoyerSMS;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
