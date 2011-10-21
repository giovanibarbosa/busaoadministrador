package br.edu.ufcg.dsc.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.persistenceDAO.EmpresaDAO;

public class EmpresaService {

	private static EmpresaService instanciaUnica;
	private EmpresaDAO empDAO;
	private List<Empresa> empresas;
	
	private EmpresaService () throws SQLException {
		empDAO = EmpresaDAO.getInstance();
	}
	
	public static EmpresaService getInstance() throws SQLException {
	
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
	
//	public boolean adicionaRota(Empresa emp, Rota r){
//		
//		if (!emp.getRotas().contains(r)){
//			emp.getRotas().add(r);
//			return true;
//		}
//		
//		return false;
//	}
	
//	public boolean removeRota(Empresa emp, Rota r){
//		
//		for (int i = 0; i < emp.getRotas().size(); i++) {
//			if (emp.getRotas().get(i).equals(r)){
//				emp.getRotas().remove(i);
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
	public List<Empresa> getEmpresas() throws SQLException{
		return empDAO.listarTodas();
	}

	public Empresa getEmpresaId(int id) throws IllegalArgumentException, SQLException {
		return empDAO.recuperar(String.valueOf(id));
		
	}
	

}
