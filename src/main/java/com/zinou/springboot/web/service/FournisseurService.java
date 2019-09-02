package com.zinou.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public interface FournisseurService {

	int inscrFournisseur(int utilsateur_id, int numeroRegistre, int numeroFiscale, String taxId);

}
