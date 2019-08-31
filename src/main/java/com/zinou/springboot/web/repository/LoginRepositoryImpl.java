package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.util.DB;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	@Autowired DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public Map<String, Object> Login(String login, String pasword) {

		String sql =   "SELECT "
				+ "    u.utilisateur_id, "
				+ "    (CASE "
				+ "        WHEN c.client_id IS NOT NULL THEN 'C' "
				+ "        WHEN f.fournisseur_id IS NOT NULL THEN 'F' "
				+ "        WHEN l.livreur_id IS NOT NULL THEN 'L' "
				+ "        WHEN adf.admine_de_filiale_id IS NOT NULL THEN 'ADF' "
				+ "        WHEN ads.admine_de_sm_id IS NOT NULL THEN 'ADS' "
				+ "        ELSE 'U' "
				+ "    END) AS type_user "
				+ "FROM "
				+ "    utilisateur u "
				+ "        LEFT JOIN "
				+ "    client c ON (u.utilisateur_id = c.utilisateur_id) "
				+ "        LEFT JOIN "
				+ "    fournisseur f ON (u.utilisateur_id = f.utilisateur_id) "
				+ "        LEFT JOIN "
				+ "    livreur l ON (u.utilisateur_id = l.utilisateur_id) "
				+ "        LEFT JOIN "
				+ "    admine_de_filiale adf ON (u.utilisateur_id = adf.utilisateur_id) "
				+ "        LEFT JOIN "
				+ "    admine_de_sm ads ON (u.utilisateur_id = ads.utilisateur_id ) "
				+ "WHERE u.login = ? AND u.pasword = ? ";

		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, pasword);

			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return Stream.of(new Object[][] {
					{ "user_id", rs.getInt(1) }, 
					{ "type", rs.getString(2) }, 
				}).collect(Collectors.toMap(data -> (String)data[0], data -> data[1]));
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return Stream.of(new Object[][] {
			{ "user_id", 0 }, 
			{ "type", "U" }, 
		}).collect(Collectors.toMap(data -> (String)data[0], data -> data[1]));
	}

}
