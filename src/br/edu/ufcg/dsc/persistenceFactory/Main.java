package br.edu.ufcg.dsc.persistenceFactory;

import java.sql.SQLException;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Horario;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.persistenceDAO.CidadeDAO;
import br.edu.ufcg.dsc.persistenceDAO.EmpresaDAO;
import br.edu.ufcg.dsc.persistenceDAO.OnibusDAO;
import br.edu.ufcg.dsc.persistenceDAO.RotaDAO;
import br.edu.ufcg.dsc.util.Tempo;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CidadeDAO cid = CidadeDAO.getInstance();
//			OnibusDAO oni = OnibusDAO.getInstance();
//			RotaDAO rota = RotaDAO.getInstance();
//			EmpresaDAO emp = EmpresaDAO.getInstance();
//
//			cid.criar(new Cidade(1.5, "Campina Grande", "Paraiba", new Ponto(
//					-7.230294, -35.881355)));
//			cid.criar(new Cidade(1.5, "João Pessoa", "Paraiba", new Ponto(
//					-7.11452, -34.860742)));
//			cid.criar(new Cidade(1.5, "Patos", "Paraiba", new Ponto(-7.025424,
//					-37.277945)));
//
//			emp.criar(new Empresa(1, "Nacional", 1960, 1));
//			emp.criar(new Empresa(2, "Cruzeiro", 1988, 1));
//			emp.criar(new Empresa(3, "Cabral", 1990, 1));
//			emp.criar(new Empresa(4, "Trans Nacional", 1987, 1));
//
//			rota.criar(new Rota(
//					"21221",
//					"preto",
//					444,
//					new Horario(4, 8, new Tempo(8, 30), new Tempo(22, 30)),
//					1,
//					"http://maps.google.com.br/maps/ms?authuser=0&vps=2&ie=UTF8&msa=0&output=kml&msid=205019086966039789595.0004ada44f3ef100f941b"));
//			rota.criar(new Rota(
//					"321231",
//					"verde",
//					3000,
//					new Horario(5, 80, new Tempo(7, 10), new Tempo(22, 00)),
//					2,
//					"http://maps.google.com.br/maps/ms?authuser=0&vps=1&ie=UTF8&msa=0&output=kml&msid=205019086966039789595.0004ae30a12acfcbe8849"));
//			
//			oni.criar(new Onibus("300", 45, 1));
//			oni.criar(new Onibus("500", 40, 2));
			
//			Cidade cidade = new Cidade(1.5, "João Pessoa", "Paraiba", new Ponto(
//					-7.11452, -34.860742));
//			cidade.setIdentificacao(1);
//			Empresa empresa = new Empresa(5, "Real");
//			System.out.println(cid.recuperaEmpresas(cidade));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
