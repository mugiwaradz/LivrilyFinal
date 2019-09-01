package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Client;
import com.zinou.springboot.web.util.DB;

@Repository
public class ClientRepositoryImpl implements ClientRepository {


	@Autowired DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public Client getClient(int client_id) {

		String sql = "SELECT * FROM Client";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			Client client = new Client(); //TODO verifié
			while(rs.next()) {
				client.setClient_ID(rs.getInt("Client_ID"));
				client.setUtilisateur_ID(rs.getInt("utilisateur_id"));
				client.setEnvoyerMail(rs.getBoolean("envoyerMail"));
				client.setEnvoyerSMS(rs.getBoolean("envoyerSMS"));
				client.setNumCarteCredit(rs.getInt("NumCarteCredit"));
			}

			return client;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return null;
	}

	@Override
	public int createClient(int utilsateur_id, int numCartCredit) {

		String sql = "INSERT INTO `Client` ( `utilisateur_id`, `NumcarteCredit`) VALUES  (?,?)";
		PreparedStatement stmt;
		try {

			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, utilsateur_id);
			stmt.setInt(2, numCartCredit);

			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();

			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return 0;
	}
//
//	public Full_User createLivreur (Full_User livreur) throws SQLException {
//
//		String sql = "INSERT INTO `Livreur` ( `utilisateur_id`, `moyenLivraison`,`typePermetConduire`,`distanceMax`) VALUES  (?,?,?,?)";
//		PreparedStatement stmt;
//
//		stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//		stmt.setInt(1, livreur.getUtilisateur().getUtilisateur_ID());
//		stmt.setString(2,livreur.getMoyenLivraison());
//		stmt.setString(3,livreur.getTypePermetConduire());
//		stmt.setInt(4,livreur.getDistanceMax());
//
//		stmt.executeUpdate();
//		ResultSet generatedKeys = stmt.getGeneratedKeys();
//
//		if (generatedKeys.next()) {
//			livreur.setLivreur_ID(generatedKeys.getInt(1));
//		}
//		return livreur;
//
//	}
//
//	public Full_User createFournisseur (Full_User fournisseur) throws SQLException {
//
//		String sql = "INSERT INTO `Fournisseur` ( `utilisateur_id`, `numeroRegistre`,`numeroFiscale`,`taxid`) VALUES (?,?,?,?)";
//		PreparedStatement stmt;
//
//		stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//		stmt.setInt(1, fournisseur.getUtilisateur().getUtilisateur_ID());
//		stmt.setInt(2,fournisseur.getNumeroGestire());
//		stmt.setInt(3,fournisseur.getNumeroFiscale());
//		stmt.setString(4,fournisseur.getTaxid());
//
//		stmt.executeUpdate();
//		ResultSet generatedKeys = stmt.getGeneratedKeys();
//
//		if (generatedKeys.next()) {
//			fournisseur.setFournisseur_ID(generatedKeys.getInt(1));
//		}
//		return fournisseur;
//
//
//	}

}