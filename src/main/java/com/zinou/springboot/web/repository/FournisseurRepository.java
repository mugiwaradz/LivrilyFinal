package com.zinou.springboot.web.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository {

	int createFournisseur(int utilsateur_id, int numeroRegistre, int numeroFiscale, String taxId);

}
