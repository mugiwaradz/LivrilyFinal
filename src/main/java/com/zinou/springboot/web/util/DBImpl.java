package com.zinou.springboot.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class DBImpl implements DB {

	private Logger log = Logger.getLogger(DBImpl.class.getName());

	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "mehdi1234";
	private final static String DB_HOST = "localhost:3306";
	private final static String DB_NAME = "livrily?useSSL=false&serverTimezone=UTC";

	@Override
	public Connection getConnection() {

		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DB_NAME, USERNAME, PASSWORD);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return con;
	}

	@Override
	public void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
