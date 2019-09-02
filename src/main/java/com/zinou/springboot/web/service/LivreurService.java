package com.zinou.springboot.web.service;

import org.springframework.stereotype.Service;

@Service
public interface LivreurService {

	int inscrLivreur(int utilsateur_id, String moyenLivraison, String typePermetConduire, int distanceMax);

}
