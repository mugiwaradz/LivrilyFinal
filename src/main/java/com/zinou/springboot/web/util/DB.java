package com.zinou.springboot.web.util;

import java.sql.Connection;

import org.springframework.stereotype.Component;

@Component
public interface DB {

	Connection getConnection();

	void closeConnection(Connection Connection);

}
