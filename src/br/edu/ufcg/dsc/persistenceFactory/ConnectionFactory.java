package br.edu.ufcg.dsc.persistenceFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String url, usuario, senha;

	public ConnectionFactory() {
		url = "s43.eatj.com:3307/busaoprojeto";
		usuario = "busaoprojeto";
		senha = "inavoigbusao";
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://" + url, usuario,
				senha);
	}
}
