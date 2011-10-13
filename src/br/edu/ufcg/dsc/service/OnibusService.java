package br.edu.ufcg.dsc.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.persistenceDAO.OnibusDAO;

public class OnibusService {
	private static OnibusService instanciaUnica;
	private OnibusDAO busDAO;
	
	private OnibusService () throws SQLException {
		busDAO = OnibusDAO.getInstance();
	}
	
	public static OnibusService getInstance() throws SQLException {
		
		if (instanciaUnica == null){
			OnibusService os = new OnibusService();
			instanciaUnica = os;
		}
		
		return instanciaUnica;
		
	}
	
	public void addOnibus (Onibus o) throws IllegalArgumentException, SQLException{
		busDAO.criar(o);		
	}
	
	public void removeOnibus(Onibus o) throws IllegalArgumentException, SQLException{
		busDAO.deletar(o);
	}
	
	public List<Onibus> getOnibus() throws SQLException{
		return busDAO.listarTodas();
	}
	
	public String getOnibusId(Onibus o) throws IllegalArgumentException, SQLException{
		return busDAO.recuperar(o.getIdentificador()).getIdentificador();
	}
	
	public Onibus getOnibusPorId(String id) throws IllegalArgumentException, SQLException {
		return busDAO.recuperar(id);
	}

}
