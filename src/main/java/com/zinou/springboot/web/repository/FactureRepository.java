package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Facture;
import com.zinou.springboot.web.model.FactureLine;
import com.zinou.springboot.web.model.Facturecomplette;


@Repository
public interface FactureRepository {

	List<Facturecomplette> getFactures(int id_facture);

	Facture createFacture(Facture Facture);

	FactureLine createFactureLine(FactureLine line);

	void updateFacture(Double volumneTotal, int Facture_id);

	ResponseEntity<Resource> printFacture(int id_facture);

}
