package com.zinou.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.repository.LivreurRepository;

@Service
public class LivreurServiceImpl implements LivreurService {

	@Autowired
	LivreurRepository Repository;

	@Override
	public int inscrLivreur(int utilsateur_id, String moyenLivraison, String typePermetConduire, int distanceMax) {
		return Repository.createLivreur(utilsateur_id, moyenLivraison, typePermetConduire, distanceMax);
	}

}
