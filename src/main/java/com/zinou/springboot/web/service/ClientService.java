package com.zinou.springboot.web.service;

import org.springframework.stereotype.Service;

import com.zinou.springboot.web.model.Client;

@Service
public interface ClientService {

	Client getClient(int client_id);

	int inscrClient(int utilsateur_id, int numCartCredit);

}
