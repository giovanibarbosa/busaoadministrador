package br.edu.ufcg.dsc.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;

public class CidadeService {

	private static CidadeService instanciaUnica;
	private List<Cidade> cidades;
	
	public CidadeService () {
		this.cidades = new ArrayList<Cidade>();
	}
	
	public static CidadeService getInstance() {
	
		if (instanciaUnica == null){
			CidadeService gc = new CidadeService();
			instanciaUnica = gc;
		}
		
		return instanciaUnica;
		
	}
	
	public boolean adicionarCidade (Cidade cid){
		
		if (!cidades.contains(cid)){
			cidades.add(cid);
			return true;
		}
		
		return false;
	}
	
	public boolean removeCidade (Cidade cid){
		
		for (int i = 0; i < cidades.size(); i++) {
			if (cidades.get(i).equals(cid)){
				cidades.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public List<Cidade> getCidadesAplicativo(){
		return this.cidades;
	}
	
	public boolean adicionaEmpresa (Cidade cid, Empresa empr){
		
		if (!cid.getEmpresasCadastradas().contains(empr)){
			cid.getEmpresasCadastradas().add(empr);
			return true;
		}
		
		return false;
	}
	
	public boolean removeEmpresa (Cidade cid, Empresa empr){
		
		for (int i = 0; i < cid.getEmpresasCadastradas().size(); i++) {
			if (cid.getEmpresasCadastradas().get(i).equals(empr)){
				cid.getEmpresasCadastradas().remove(i);
				return true;
			}
		}
		
		return false;
	}
}
