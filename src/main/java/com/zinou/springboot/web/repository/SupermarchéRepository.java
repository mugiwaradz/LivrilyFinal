package com.zinou.springboot.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zinou.springboot.web.model.Supermarche;

@Repository
public interface SupermarchéRepository {

	Supermarche AjouterSupermarché(Supermarche supermarché);

	boolean SupprimerSupermarché(int id_supermarché);

	List<Supermarche> getSupermarche();

}
