package com.zinou.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Supermarché;
import com.zinou.springboot.web.repository.SupermarchéRepository;

@Service
public class SupermarchéServiceImpl implements SupermarchéService {

	@Autowired
	SupermarchéRepository repository;

	@Override
	public Supermarché AjouterSupermarché(Supermarché supermarché) {
		return repository.AjouterSupermarché(supermarché);
	}

	@Override
	public boolean suprimerSupermarché(int id_supermarché) {

		return repository.SupprimerSupermarché(id_supermarché);
	}



}
