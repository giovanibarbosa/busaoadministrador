package br.edu.ufcg.dsc.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.persistenceDAO.CidadeDAO;

public class CidadeService {

	private static CidadeService instanciaUnica;
	//?????????
	private CidadeDAO cd;
	
	public CidadeService () throws SQLException {
		cd = CidadeDAO.getInstance();
	}
	
	public static CidadeService getInstance() throws SQLException {
	
		if (instanciaUnica == null){
			CidadeService gc = new CidadeService();
			instanciaUnica = gc;
		}
		
		return instanciaUnica;
		
	}
	
	public void adicionarCidade (Cidade cid) throws IllegalArgumentException, SQLException{
		cd.criar(cid);
	}
	
	public void removeCidade (Cidade cid) throws IllegalArgumentException, SQLException{
		cd.deletar(cid);
	}
	
	public List<Cidade> getCidadesAplicativo() throws SQLException{
		return cd.listarTodas();
	}
	
	//Ver como fica isso no DAO
	public boolean adicionaEmpresa (Cidade cid, Empresa empr){
		
		if (!cid.getEmpresasCadastradas().contains(empr)){
			cid.getEmpresasCadastradas().add(empr);
			return true;
		}
		
		return false;
	}
	
	//Ver como fica isso no DAO
	public boolean removeEmpresa (Cidade cid, Empresa empr){
		
		for (int i = 0; i < cid.getEmpresasCadastradas().size(); i++) {
			if (cid.getEmpresasCadastradas().get(i).equals(empr)){
				cid.getEmpresasCadastradas().remove(i);
				return true;
			}
		}
		
		return false;
	}

	//Aqui o id é incremental. Como pego ele ? Acho que tem que fazer um metodo especifico no DAOs
	public String getCidadePorId(int idCidade) {
		return cd.recuperarCidadePorId(idCidade);
	}
}
