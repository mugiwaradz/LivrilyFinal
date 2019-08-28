package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}