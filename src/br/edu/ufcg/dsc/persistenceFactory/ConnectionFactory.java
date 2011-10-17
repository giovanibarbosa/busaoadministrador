package br.edu.ufcg.dsc.persistenceFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String url, usuario, senha;

	public ConnectionFactory() {
		url = "sertaonosso.com.br:3306/sertaono_busaoproject";
		usuario = "sertaono_busao";
		senha = "inavoigbusao";
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://" + url, usuario,
				senha);
	}
}
