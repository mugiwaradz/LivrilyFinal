package com.zinou.springboot.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Livraison;
import com.zinou.springboot.web.model.Livraisoncomplette;

@Service
public interface LivraisonService {

	List<Livraisoncomplette> getLivraisons( int livraison_id);

	boolean createLivraison(int id_commande, int livreur_id);

	boolean sendMail(int user_id);

	boolean ValiderLivraison(int id);

	List<Livraison> getmesLivraisons(int id, Boolean estlivre);


}
