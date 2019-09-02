package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.util.DB;

@Repository
public class FournisseurRepositoryImpl implements FournisseurRepository {

	@Autowired
	DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public int createFournisseur(int utilsateur_id, int numeroRegistre, int numeroFiscale, String taxId) {

		String sql = "INSERT INTO `Fournisseur` ( `utilisateur_id`, `numeroRegistre`,`numeroFiscale`,`taxid`) VALUES (?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, utilsateur_id);
			stmt.setInt(2, numeroRegistre);
			stmt.setInt(3, numeroFiscale);
			stmt.setString(4, taxId);

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
}