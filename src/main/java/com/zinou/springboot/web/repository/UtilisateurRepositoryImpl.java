package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Full_User;
import com.zinou.springboot.web.model.Utilisateur;
import com.zinou.springboot.web.util.DB;
import com.zinou.springboot.web.util.ExacteUser;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

	@Autowired
	DB db;
	Logger log = Logger.getLogger(UtilisateurRepositoryImpl.class.getName());
	Full_User user = new Full_User();

	@Override
	public List<Full_User> getUtilsateurs(int type_user, String sql) {
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Full_User> utilsateurs = new ArrayList<>();
			while (rs.next()) {

				Full_User utilisateur = ExacteUser.getutilisateur(rs);
				utilisateur.setType_user(type_user);
				switch (type_user) {
				case 1:
					utilisateur.setNumCarteCredit((rs.getInt("NumcarteCredit")));
					utilisateur.setEnvoyerMail((rs.getBoolean("EnvoyerMail")));
					utilisateur.setEnvoyerSMS((rs.getBoolean("EnvoyerSMS")));
					utilisateur.setClient_ID(rs.getInt("client_id"));
					break;
				case 2:
					utilisateur.setLivreur_ID(rs.getInt("livreur_id"));
					utilisateur.setMoyenLivraison((rs.getString("moyenLivraison")));
					utilisateur.setTypePermetConduire((rs.getString("typePermetConduire")));
					utilisateur.setDistanceMax((rs.getInt("distanceMax")));
//					utilisateur.setEst_disponible(rs.getBoolean("estdisponible"));

					break;
				case 3:
					utilisateur.setFournisseur_ID(rs.getInt("fournisseur_id"));
					utilisateur.setNumeroFiscale((rs.getInt("numeroFiscale")));
					utilisateur.setNumeroGestire((rs.getInt("numeroRegistre")));
					utilisateur.setTaxid((rs.getString("taxid")));
					break;

				default:
					break;
				}
				utilsateurs.add(utilisateur);
			}

			return utilsateurs;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Utilisateur createutilisateurs(Utilisateur utilisateur) {

		String sql = "INSERT INTO `utilisateur` ( `nom`, `prenom`, `datedenaissance`, `lieudenaissance`, `phone`, `phone2`, `email`, `login`, `pasword`)  VALUES  (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getNom());
			stmt.setString(2, utilisateur.getPrenom());

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = dateFormat.parse(utilisateur.getDateNaissance());

			stmt.setTimestamp(3, new Timestamp(parsedDate.getTime()));
			stmt.setString(4, utilisateur.getLieudeudeNaissance());
			stmt.setInt(5, utilisateur.getPhone1());
			stmt.setInt(6, utilisateur.getPhone2());
			stmt.setString(7, utilisateur.getEmail());
			stmt.setString(8, utilisateur.getLogin());
			stmt.setString(9, utilisateur.getPasword());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				utilisateur.setUtilisateur_ID(generatedKeys.getInt(1));
				// Inscription inscription =new Inscription();
				// switch (full_user.getType_user()) {
				//
				// case 1:inscription.createClient(1);
				// break;
				//
				//// case 2:inscription.createLivreur(full_user);
				//// break;
				////
				//// case 3:inscription.createFournisseur(full_user);
				//// break;
				//
				// default:
				// break;
				// }

			} else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return utilisateur;
	}

	@Override
	public boolean deleteutilisateurs(int id_utilisateur) {
		String sql = "DELETE FROM utilisateur WHERE utilisateur_id=?";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, id_utilisateur);

			int ret = stmt.executeUpdate();
			return ret > 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return false;
	}

}
