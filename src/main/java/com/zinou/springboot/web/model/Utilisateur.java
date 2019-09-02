package com.zinou.springboot.web.model;

public class Utilisateur {
	private String Nom;
	private String Prenom;
	private String DateNaissance;
	private String LieudeudeNaissance;
	private String Email;
	private String Login;
	private String Pasword;
	private int Utilisateur_ID;
	private int Phone1;
	private int Phone2;
	private String type_user;

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getLieudeudeNaissance() {
		return LieudeudeNaissance;
	}

	public void setLieudeudeNaissance(String lieudeudeNaissance) {
		LieudeudeNaissance = lieudeudeNaissance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPasword() {
		return Pasword;
	}

	public void setPasword(String pasword) {
		Pasword = pasword;
	}

	public int getUtilisateur_ID() {
		return Utilisateur_ID;
	}

	public void setUtilisateur_ID(int utilisateurId) {
		Utilisateur_ID = utilisateurId;
	}

	public int getPhone1() {
		return Phone1;
	}

	public void setPhone1(int phone1) {
		Phone1 = phone1;
	}

	public int getPhone2() {
		return Phone2;
	}

	public void setPhone2(int phone2) {
		Phone2 = phone2;
	}

	public String getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public String getType_user() {
		return type_user;
	}

	public void setType_user(String type_user) {
		this.type_user = type_user;
	}

}
