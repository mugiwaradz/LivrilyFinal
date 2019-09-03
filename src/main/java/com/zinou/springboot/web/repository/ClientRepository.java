package com.zinou.springboot.web.repository;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Client;

@Service
public interface ClientRepository {

	Client getClient(int client_id);

	int createClient(int utilsateur_id, int numCartCredit, String latitude, String longitude);

}
