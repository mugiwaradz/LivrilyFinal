package com.zinou.springboot.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.model.Facturecomplette;
import com.zinou.springboot.web.service.FactureService;


@Controller
public class FactureController {

	@Autowired
	FactureService service ;

	@GetMapping("Factures")
	List<Facturecomplette> getFactures(){
		return service.getFactures();
	}

	@PostMapping("Factures")
	boolean createFacture(@RequestParam int id_livraison){
		return service.createFacture(id_livraison);
	}


	@GetMapping(value = "printFacture", produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile(@RequestParam int id_facture)
			throws IOException {
		return service.printFacture(id_facture);
	}

}
