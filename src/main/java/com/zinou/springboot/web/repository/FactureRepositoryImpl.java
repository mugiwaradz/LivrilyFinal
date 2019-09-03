package com.zinou.springboot.web.repository;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Facture;
import com.zinou.springboot.web.model.FactureLine;
import com.zinou.springboot.web.model.Facturecomplette;
import com.zinou.springboot.web.util.DB;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
public class FactureRepositoryImpl implements FactureRepository {

	@Autowired
	DB db;
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public List<Facturecomplette> getFactures(int id_facture) {

		String sql = "SELECT * FROM Facture inner join Facture_line "
				+ "on (Facture.Facture_id = Facture_line.Facture_id)";

		if (id_facture > 0)
			sql = sql + " WHERE facture.Facture_id = ? ";

		PreparedStatement stmt;

		try {
			stmt = db.getConnection().prepareStatement(sql);

			if (id_facture > 0)
				stmt.setInt(1, id_facture);

			ResultSet rs = stmt.executeQuery();
			List<Facturecomplette> factures = new ArrayList<>();

			int old_facture_id = 0;

			Facturecomplette facturecomplette = null;
			List<FactureLine> facturelines = null;
			while (rs.next()) {
				if (old_facture_id != rs.getInt(1)) {

					facturecomplette = new Facturecomplette();
					factures.add(facturecomplette);

					facturelines = new ArrayList<>();
					Facture facture = new Facture();
					facture.setFacture_ID(rs.getInt(1));
					facture.setLivraison_ID(rs.getInt(2));
					facture.setClient_ID(rs.getInt(3));
					facture.setNumeroFacture(rs.getString(4));
					facture.setTarif(rs.getString(5));
					facture.setTotal(rs.getDouble(6));
					facture.setTva(rs.getInt(7));

					facturecomplette.setFacture(facture);
					facturecomplette.setFacturelines(facturelines);

					old_facture_id = rs.getInt(1);
				}

				FactureLine factureLine = new FactureLine();
				factureLine.setFactureLine_ID(rs.getInt("facture_line_id"));
				factureLine.setProduitID(rs.getInt("produit_id"));
				factureLine.setQuantityFacture(rs.getInt("quantityFacture"));
				factureLine.setTotalLine(rs.getDouble("totalLine"));
				factureLine.setPrix(rs.getDouble("prix"));

				facturelines.add(factureLine);
			}
			return factures;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Facture createFacture(Facture Facture) {

		// TODO corriger requette
		String sql = "INSERT INTO `Facture` ( `Livraison_ID`, `Client_ID`, `NumeroFacture`, `tarif`, `tva`) VALUES  (?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, Facture.getLivraison_ID());
			stmt.setInt(2, Facture.getClient_ID());
			stmt.setString(3, Facture.getNumeroFacture());
			stmt.setString(4, Facture.getTarif());
			stmt.setInt(5, Facture.getTva());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				Facture.setFacture_ID(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating Facture failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return Facture;

	}

	@Override
	public FactureLine createFactureLine(FactureLine line) {

		// TODO corriger requette
		String sql = "INSERT INTO `Facture_Line` ( `Facture_ID`, `produit_id`, `quantityFacture`, `totalLine`,`prix`) VALUES  (?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, line.getFacture_ID());
			stmt.setInt(2, line.getProduitID());
			stmt.setInt(3, line.getQuantityFacture());
			stmt.setDouble(4, line.getTotalLine());
			stmt.setDouble(5, line.getPrix());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				line.setFactureLine_ID(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating Facture failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return line;

	}

	@Override
	public void updateFacture(Double volumneTotal, int Facture_id) {

		// TODO corriger requette
		String sql = "UPDATE `Facture` set total = ?  where facture_id = ? ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(2, Facture_id);
			stmt.setDouble(1, volumneTotal);

			stmt.executeUpdate();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

	}

	@Override
	public ResponseEntity<Resource> printFacture(int id_facture) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("facture_id", id_facture);
		Connection datasource = db.getConnection();
		try {
			JasperReport jrxmlFile = JasperCompileManager.compileReport("src/main/resources/facture.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jrxmlFile, parameters, datasource); // with
																										// datasource

			String filename = "facture_" + id_facture + ".pdf";
			JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

			File file = new File(filename);

			HttpHeaders header = new HttpHeaders();
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
			header.add("Cache-Control", "no-cache, no-store, must-revalidate");
			header.add("Pragma", "no-cache");
			header.add("Expires", "0");

			Path path = Paths.get(file.getAbsolutePath());
			ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

			return ResponseEntity.ok().headers(header).contentLength(file.length())
					.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return null;
	}
	
	
	@Override
	public void updateLivraison(int livraison_id) {
		
		String sql ="UPDATE `Livraison` SET `statue` = 'Facturer' WHERE (`livraison_id` = ?)";

		PreparedStatement stmt;

		
			try {
				stmt = db.getConnection().prepareStatement(sql);
			

			stmt.setInt(1, livraison_id);

		 stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


}
