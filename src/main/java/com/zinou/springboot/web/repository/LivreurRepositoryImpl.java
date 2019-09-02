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
public class LivreurRepositoryImpl implements LivreurRepository {

	@Autowired
	DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public int createLivreur(int utilsateur_id, String moyenLivraison, String typePermetConduire, int distanceMax) {

		String sql = "INSERT INTO `Livreur` ( `utilisateur_id`, `moyenLivraison`,`typePermetConduire`,`distanceMax`) VALUES  (?,?,?,?)";
		PreparedStatement stmt;
		try {

			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, utilsateur_id);
			stmt.setString(2, moyenLivraison);
			stmt.setString(3, typePermetConduire);
			stmt.setInt(4, distanceMax);

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