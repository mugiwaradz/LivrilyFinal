package com.zinou.springboot.web.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface LivreurRepository {

	int createLivreur(int utilsateur_id, String moyenLivraison, String typePermetConduire, int distanceMax);

}
