package br.edu.ufcg.dsc.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.persistenceDAO.CidadeDAO;

public class CidadeService {

	private static CidadeService instanciaUnica;
	private CidadeDAO cd;

	private CidadeService() throws SQLException {
		cd = CidadeDAO.getInstance();
	}

	public static CidadeService getInstance() throws SQLException {

		if (instanciaUnica == null) {
			CidadeService gc = new CidadeService();
			instanciaUnica = gc;
		}

		return instanciaUnica;

	}

	public void adicionarCidade(Cidade cid) throws 
			SQLException {
		cd.criar(cid);
	}

	public void removeCidade(Cidade cid) throws 
			SQLException {
		cd.deletar(cid);
	}

	public List<Cidade> getCidadesAplicativo() throws SQLException {
		return cd.listarTodas();
	}

	public Cidade getCidadePorNome(String nome)
			throws  SQLException {
		return cd.recuperarCidadePorNome(nome);
	}
	
	public Cidade getCidadePorId(int id) throws 
			SQLException {
		return cd.recuperar(id);
	}
}
