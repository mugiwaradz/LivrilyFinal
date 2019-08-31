package com.zinou.springboot.web.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	Map<String, Object> Login(String login, String password);

}
