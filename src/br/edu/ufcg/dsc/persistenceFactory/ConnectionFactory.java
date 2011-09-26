package br.edu.ufcg.dsc.persistenceFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String url, usuario, senha;

	public ConnectionFactory() {
		url = ""; // sera o url com o nome do servidor etc...
		usuario = ""; // nome do usuario do bd
		senha = ""; // senha do bd
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://" + url, usuario,
				senha);
	}
}
