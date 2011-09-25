package br.edu.ufcg.dsc.facade;

import java.util.List;

import br.edu.ufcg.dsc.bean.Horario;
import br.edu.ufcg.dsc.bean.Ponto;

public interface BusaoFacadeIF {

	public String getValor (String atributo, int id);
	
	public int pesquisaRota (String nome);
	
	public List<Ponto> obterPontos (String idRota);
	
	public List<Horario> obterHorarios (String idRota);
	
	public String proximaPassagem (String idRota);
	
	public Ponto pesquisaPorPonto (double latitude, double longitude);
	
	public List<Ponto> pesquisaPorDoisPontos (double latitude1, double longitude1, double latitude2, double longitude2);
	
	public String obterCidade (int idCidade);
	
	
}
