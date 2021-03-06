package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Supermarche;

@Service
public interface SupermarchéService {

	Supermarche AjouterSupermarché(Supermarche supermarché);

	boolean suprimerSupermarché(int id_supermarché);

	List<Supermarche> getSupermarches();

}
