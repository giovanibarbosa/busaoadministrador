package br.edu.ufcg.dsc.persistenceFactory;

import java.sql.SQLException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new ConnectionFactory().getConnection();
			System.out.println("conectou");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
