package com.zinou.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.repository.FournisseurRepository;

@Service
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	FournisseurRepository repository;

	@Override
	public int inscrFournisseur(int utilsateur_id, int numeroRegistre, int numeroFiscale, String taxId) {
		return repository.createFournisseur(utilsateur_id, numeroRegistre, numeroFiscale, taxId);
	}

}
