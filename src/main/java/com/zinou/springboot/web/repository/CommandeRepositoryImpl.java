package com.zinou.springboot.web.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Commande;
import com.zinou.springboot.web.model.CommandeLine;
import com.zinou.springboot.web.model.Commandecomplette;
import com.zinou.springboot.web.util.DB;

@Repository
public class CommandeRepositoryImpl implements CommandeRepository {
	@Autowired
	DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public List<Commandecomplette> getCommandes(int id_commande,String statue) {

		ResultSet rs = null;
		String sql = null;
		try {
			if (id_commande > 0) {
				sql = "SELECT * FROM commande inner join commande_line "
						+ "on (commande.commande_id = commande_line.commande_id)"
						+ " where commande.statue = ? and commande.commande_id = (?) ";
				PreparedStatement stmt;
				stmt = db.getConnection().prepareStatement(sql);
				stmt.setString(1, statue);
				stmt.setInt(2, id_commande);

				rs = stmt.executeQuery();
			} else {
				sql = "SELECT * FROM commande inner join commande_line "
						+ "on (commande.commande_id = commande_line.commande_id)"
						+ " where commande.statue = ? "
						+ "order by commande.datecommande";
				PreparedStatement stmt;
				stmt = db.getConnection().prepareStatement(sql);
				stmt.setString(1, statue);
				rs = stmt.executeQuery();

			}

			List<Commandecomplette> commandes = new ArrayList<>();

			int old_comande_id = 0;

			Commandecomplette commandecomplette = null;
			List<CommandeLine> commandelines = null;

			while (rs.next()) {

				if (old_comande_id != rs.getInt(1)) {

					commandecomplette = new Commandecomplette();
					commandes.add(commandecomplette);

					commandelines = new ArrayList<>();

					Commande commande = new Commande();
					commande.setCommande_ID(rs.getInt(1));
					commande.setSupermarché_ID(rs.getInt(2));
					commande.setClinet_ID(rs.getInt(3));
					commande.setDtaedeCommande(rs.getDate(4));
					commande.setStatue(rs.getString(5));
					commande.setNumeroCommande(rs.getString(6));
					commande.setTarif(rs.getString(7));
					commande.setTotal(rs.getDouble("total"));
					commande.setTva(rs.getInt(9));
					commandecomplette.setCommande(commande);

					commandecomplette.setCommandelines(commandelines);

					old_comande_id = rs.getInt(1);
				}

				CommandeLine commandeline = new CommandeLine();
				commandeline.setCommandeLine_ID(rs.getInt("commande_line_id"));
				commandeline.setProduit_ID(rs.getInt("produit_id"));
				commandeline.setPrix(rs.getDouble("prix"));
				commandeline.setQuantityCommande(rs.getInt("quantityCommande"));
				commandeline.setTotalLine(rs.getDouble("totalLine"));
				commandelines.add(commandeline);
			}
			return commandes;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CommandeLine saveCommandeLine(CommandeLine line) {

		// TODO corriger requette
		String sql = "INSERT INTO `Commande_line` ( `Commande_ID`, `produit_id`, `prix`, `quantityCommande`, `totalLine`) VALUES  (?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, line.getCommande_ID());
			stmt.setInt(2, line.getProduit_ID());
			stmt.setDouble(3, line.getPrix());
			stmt.setInt(4, line.getQuantityCommande());
			stmt.setDouble(5, line.getTotalLine());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				line.setCommandeLine_ID(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating commande line failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return line;

	}

	@Override
	public void updateCommande(Double prixTotal, int commande_ID, String numeroCommande) {

		// TODO corriger requette
		String sql = "UPDATE `Commande` set total = ?, numeroCommande = ? where commande_ID = ? ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setDouble(1, prixTotal);
			stmt.setString(2, numeroCommande);
			stmt.setInt(3, commande_ID);

			stmt.executeUpdate();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

	}

	@Override
	public Commande saveCommande(Commande commande) {

		// TODO corriger requette
		// TODO plsql numero commande sequence
		String sql = "INSERT INTO `Commande` ( `client_id`, `supermarche_id`, `datecommande`, `statue`, `NumeroCommande`, `tarif`, `tva`) VALUES  (?,?,?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, commande.getClinet_ID());
			stmt.setInt(2, commande.getSupermarché_ID());
			stmt.setTimestamp(3, new Timestamp(commande.getDtaedeCommande().getTime()));
			stmt.setString(4, commande.getStatue());
			stmt.setString(5, commande.getNumeroCommande());
			stmt.setInt(6, 0);
			stmt.setInt(7, commande.getTva());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				commande.setCommande_ID(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating commande failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return commande;

	}

	@Override
	public List<Commandecomplette> getCommandes(String client_id) {

		ResultSet rs = null;
		String sql = null;
		try {
			sql = "SELECT * FROM commande inner join commande_line "
					+ "on (commande.commande_id = commande_line.commande_id)"
					+ " where commande.client_id = (?) ";
			PreparedStatement stmt;
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(client_id));
			
			rs = stmt.executeQuery();
			List<Commandecomplette> commandes = new ArrayList<>();

			int old_comande_id = 0;

			Commandecomplette commandecomplette = null;
			List<CommandeLine> commandelines = null;

			while (rs.next()) {

				if (old_comande_id != rs.getInt(1)) {

					commandecomplette = new Commandecomplette();
					commandes.add(commandecomplette);

					commandelines = new ArrayList<>();

					Commande commande = new Commande();
					commande.setCommande_ID(rs.getInt(1));
					commande.setSupermarché_ID(rs.getInt(2));
					commande.setClinet_ID(rs.getInt(3));
					commande.setDtaedeCommande(rs.getDate(4));
					commande.setStatue(rs.getString(5));
					commande.setNumeroCommande(rs.getString(6));
					commande.setTarif(rs.getString(7));
					commande.setTotal(rs.getDouble("total"));
					commande.setTva(rs.getInt(9));
					commandecomplette.setCommande(commande);

					commandecomplette.setCommandelines(commandelines);

					old_comande_id = rs.getInt(1);
				}

				CommandeLine commandeline = new CommandeLine();
				commandeline.setCommandeLine_ID(rs.getInt("commande_line_id"));
				commandeline.setProduit_ID(rs.getInt("produit_id"));
				commandeline.setPrix(rs.getDouble("prix"));
				commandeline.setQuantityCommande(rs.getInt("quantityCommande"));
				commandeline.setTotalLine(rs.getDouble("totalLine"));
				commandelines.add(commandeline);
			}
			return commandes;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
