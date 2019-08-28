package com.zinou.springboot.web.service;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Supermarché;

@Service
public interface SupermarchéService {
	
	
	
	Supermarché AjouterSupermarché(Supermarché supermarché);
	
	boolean suprimerSupermarché(int id_supermarché);

}
