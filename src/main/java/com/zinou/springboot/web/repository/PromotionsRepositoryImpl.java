package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.util.DB;

@Repository
public class PromotionsRepositoryImpl implements PromotionsRepository {
	@Autowired
	DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public int postPromotion(int promotion, int produit_ID) {

		String sql = "UPDATE `produit` SET `promotion` = ? WHERE (`produit_id` = ?);";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, promotion);
			stmt.setInt(2, produit_ID);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return promotion;
	}

	@Override
	public List<Produit> getPromotion(int categorieProduit_ID) {

		String sql = "SELECT * FROM  produit inner join categorie_produit on (produit.categorie_produit_id = categorie_produit.categorie_produit_id)";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Produit> produits = new ArrayList<>();
			while (rs.next()) {
				Produit produit = new Produit();
				produit.setCategoreProduit_ID(categorieProduit_ID);
				produit.setNomProduit(rs.getString("nom"));
				produit.setPromotion(rs.getInt("promotion"));
				produit.setImage(rs.getString("image"));
				produit.setPrixDevante(rs.getDouble("prix_vente"));
				if (produit.getPromotion() > 0) {
					produit.setPrixDevante((produit.getPrixDevante() * produit.getPromotion()) / 100);
					produits.add(produit);
				}
			}

			return produits;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;

	}

}
