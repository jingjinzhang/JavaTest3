package com.hand.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	private static final ConnectionFactory factory = new ConnectionFactory();

	static {
		Properties properties = new Properties();

		try {
			InputStream is = ConnectionFactory.class.getClassLoader().
					getResourceAsStream("dbConfig.properties");
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("============配置文件读取失败============");
		}

		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}

	private ConnectionFactory() {

	}

	public static ConnectionFactory getInstance() {
		return factory;
	}

	public Connection makeConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args){
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection conn = connectionFactory.makeConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getInt("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
