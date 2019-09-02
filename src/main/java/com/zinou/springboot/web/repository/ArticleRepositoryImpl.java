package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.FullProduit;
import com.zinou.springboot.web.model.Produit;
import com.zinou.springboot.web.util.DB;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

	@Autowired
	DB db;

	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public FullProduit getProduit(int id_article) {

		String sql = "select * FROM Produit inner join categorie_produit on "
				+ "(Produit.categorie_produit_id = categorie_produit.categorie_produit_id) WHERE produit_id = ? ;";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, id_article);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return getProduit(rs);

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return null;
	}

	@Override
	public List<FullProduit> getProduits() {

		String sql = "select * FROM Produit inner join categorie_produit on "
				+ "(Produit.categorie_produit_id = categorie_produit.categorie_produit_id)  order by Produit.categorie_produit_id ;";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<FullProduit> produits = new ArrayList<>();
			while (rs.next()) {
				produits.add(getProduit(rs));
			}

			return produits;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return null;
	}

	@Override
	public Produit createProduits(Produit produit) {

		String sql = "INSERT INTO `produit` ( `nom`, `categorie_produit_id`, `prix_achat`, `prix_vente`, `fournisseur_id`, `reference`,`image`,`quantite`) VALUES  (?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, produit.getNomProduit());
			stmt.setInt(2, produit.getCategoreProduit_ID());
			stmt.setDouble(3, produit.getPrixDachat());
			stmt.setDouble(4, produit.getPrixDevante());
			stmt.setInt(5, produit.getFournisseur_ID());
			stmt.setString(6, produit.getReferance());
			stmt.setString(7, produit.getImage());
			stmt.setInt(8, produit.getQuantite());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				produit.setProduit_ID(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return produit;
	}

	@Override
	public boolean deleteProduits(int id_article) {
		String sql = "DELETE FROM Produit WHERE produit_id=?";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, id_article);

			int ret = stmt.executeUpdate();
			return ret > 0;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return false;
	}

	private FullProduit getProduit(ResultSet rs) throws SQLException {
		FullProduit produit = new FullProduit();
		produit.setProduit_ID(rs.getInt(1));
		produit.setNomProduit(rs.getString(2));
		produit.setNomCategore(rs.getString("nom_categorie"));
		produit.setPrixDachat(rs.getDouble(4));
		produit.setPrixDevante(rs.getDouble(5));
		produit.setFournisseur_ID(rs.getInt(6));
		produit.setImage(rs.getString(7));
		produit.setReferance(rs.getString(8));
		produit.setQuantite(rs.getInt(10));
		produit.setPromotion(rs.getInt("promotion"));

		return produit;

	}

}
