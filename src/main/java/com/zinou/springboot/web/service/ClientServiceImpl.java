package com.zinou.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Client;
import com.zinou.springboot.web.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository Repository;

	@Override
	public Client getClient(int client_id) {
		return Repository.getClient(client_id);
	}

	@Override
	public int inscrClient(int utilsateur_id, int numCartCredit, String latitude, String longitude) {
		return Repository.createClient(utilsateur_id, numCartCredit, latitude, longitude);
	}

}
