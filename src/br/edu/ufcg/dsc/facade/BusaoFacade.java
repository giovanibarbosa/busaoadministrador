package br.edu.ufcg.dsc.facade;

import java.util.List;

import br.edu.ufcg.dsc.bean.Horario;
import br.edu.ufcg.dsc.bean.Ponto;

public class BusaoFacade implements BusaoFacadeIF {

	@Override
	public String getValor(String atributo, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pesquisaRota(String nome) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Ponto> obterPontos(String idRota) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horario> obterHorarios(String idRota) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String proximaPassagem(String idRota) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ponto pesquisaPorPonto(double latitude, double longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ponto> pesquisaPorDoisPontos(double latitude1,
			double longitude1, double latitude2, double longitude2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obterCidade(int idCidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
