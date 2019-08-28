package com.zinou.springboot.web.repository;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Supermarché;

@Repository
public interface SupermarchéRepository {
	
	
		
	Supermarché AjouterSupermarché(Supermarché supermarché);
	
	boolean SupprimerSupermarché(int id_supermarché);




}
