package br.edu.ufcg.dsc.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Rota;

public class EmpresaService {

	private static EmpresaService instanciaUnica;
	private List<Empresa> empresas;
	
	public EmpresaService () {
		this.empresas = new ArrayList<Empresa>();
	}
	
	public static EmpresaService getInstance() {
	
		if (instanciaUnica == null){
			EmpresaService es = new EmpresaService();
			instanciaUnica = es;
		}
		
		return instanciaUnica;
		
	}
	
	public boolean alterarRota(Empresa emp, Rota novaRota){
		//TODO
		return false;
	}
	
	public boolean adicionaRota(Empresa emp, Rota r){
		
		if (!emp.getRotas().contains(r)){
			emp.getRotas().add(r);
			return true;
		}
		
		return false;
	}
	
	public boolean removeRota(Empresa emp, Rota r){
		
		for (int i = 0; i < emp.getRotas().size(); i++) {
			if (emp.getRotas().get(i).equals(r)){
				emp.getRotas().remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public List<Empresa> getEmpresas(){
		return empresas;
	}
}
