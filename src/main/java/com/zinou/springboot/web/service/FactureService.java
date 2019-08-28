package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Facturecomplette;


@Service
public interface FactureService {

	List<Facturecomplette> getFactures();

	boolean createFacture(int id_facture);

	ResponseEntity<InputStreamResource> printFacture(int id_facture);

}
