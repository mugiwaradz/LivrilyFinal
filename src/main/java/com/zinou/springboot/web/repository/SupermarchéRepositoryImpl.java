package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Supermarche;
import com.zinou.springboot.web.util.DB;

@Repository
public class SupermarchéRepositoryImpl implements SupermarchéRepository {

	@Autowired
	DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public Supermarche AjouterSupermarché(Supermarche supermarché) {

		String sql = "INSERT INTO `supermarche` ( `filiale_id`, `nom`, `telephone`, `email`) VALUES (?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, supermarché.getFiliale_ID());
			stmt.setString(2, supermarché.getNomSupermarche());
			stmt.setInt(3, supermarché.getTelephoneSupermarche());
			stmt.setString(4, supermarché.getEmailSupermarche());

			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();

			if (generatedKeys.next()) {
				supermarché.setSupermarche_ID(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating Supermarché failed, no ID obtained.");
			}

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return supermarché;
	}

	@Override
	public boolean SupprimerSupermarché(int id_supermarché) {
		String sql = "DELETE FROM Supermarche  WHERE supermarche_id=?";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, id_supermarché);

			int ret = stmt.executeUpdate();
			return ret > 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return false;

	}

}
