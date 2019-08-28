
package com.zinou.springboot.web.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository {

	boolean Login(String login, String pasword);

}
