package com.zinou.springboot.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zinou.springboot.web.service.FactureService;

@Controller
public class FactureController {

	@Autowired
	FactureService service;

	@RequestMapping(value = "/Factures", method = RequestMethod.GET)
	String getLivraisons(@RequestParam(required = false) String id_facture, ModelMap model) {

		int id = id_facture == null || id_facture.length() == 0 ? 0 : Integer.parseInt(id_facture);
		model.put("invoices", service.getFactures(id));

		return "Factures";

	}

	@RequestMapping(value = "/FacturesDetail", method = RequestMethod.GET)
	String getFacturesDetail(@RequestParam(required = false) String id_facture, ModelMap model) {

		int id = Integer.parseInt(id_facture);
		model.put("invoice", service.getFactures(id).get(0));

		return "FacturesDetail";

	}

	@PostMapping("Factures")
	boolean createFacture(@RequestParam int id_livraison) {
		return service.createFacture(id_livraison);
	}

	@GetMapping(value = "printFacture", produces = "application/pdf")
	public ResponseEntity<Resource> downloadPDFFile(@RequestParam String id_facture) throws IOException {
		return service.printFacture(Integer.parseInt(id_facture));
	}

}
