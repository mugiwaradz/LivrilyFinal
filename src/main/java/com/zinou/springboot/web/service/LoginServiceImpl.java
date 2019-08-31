package com.zinou.springboot.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zinou.springboot.web.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository repository;

	@Override
	public Map<String, Object> Login(String login, String password) {

		return repository.Login(login, password);

	}

}
