
package com.zinou.springboot.web.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository {

	Map<String, Object> Login(String login, String pasword);

}
