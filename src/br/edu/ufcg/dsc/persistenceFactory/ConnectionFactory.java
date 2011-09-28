package br.edu.ufcg.dsc.persistenceFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String url, usuario, senha;

	public ConnectionFactory() {
		url = "s11.eatj.com:3307/busaoproject";
		usuario = "busaoproject";
		senha = "inavoigbusao";
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://" + url, usuario,
				senha);
	}
}
