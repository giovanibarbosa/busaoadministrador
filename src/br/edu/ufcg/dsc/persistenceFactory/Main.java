package br.edu.ufcg.dsc.persistenceFactory;

import java.sql.SQLException;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.persistenceDAO.CidadeDAO;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CidadeDAO cid = CidadeDAO.getInstance();
			Cidade cidade = new Cidade(1, 1.5, "Campina Grande", "Paraiba", new Ponto(30, 20));
			cid.deletar(cidade);
			System.out.println("deletou");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
