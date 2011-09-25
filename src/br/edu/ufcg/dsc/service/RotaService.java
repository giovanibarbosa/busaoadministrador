package br.edu.ufcg.dsc.service;

import java.util.List;

import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.util.Tempo;


public class RotaService {

	private static RotaService instanciaUnica;
	private final Ponto INTEGRACAO = new Ponto (-7.34, -.765);
	
	public static RotaService getInstance() {
		
		if (instanciaUnica == null){
			RotaService rs = new RotaService();
			instanciaUnica = rs;
		}
		
		return instanciaUnica;
		
	}
	
	public boolean adicionaOnibusNaRota (Rota r, Onibus o){
		
		if (!r.getOnibusParticipantes().contains(o)){
			r.getOnibusParticipantes().add(o);
			return true;
		}
		
		return false;
	}
	
	public boolean removeOnibusDaRota (Rota r, Onibus o){
		
		for (int i = 0; i < r.getOnibusParticipantes().size(); i++) {
			if (r.getOnibusParticipantes().get(i).equals(o)){
				r.getOnibusParticipantes().remove(i);
				return true;
			}
		}
	
		return false;
	}

	public boolean adicionaPontoRota (Rota r, Ponto p){
		
		if (!r.getPontos().contains(p)){
			r.getPontos().add(p);
			return true;
		}
		
		return false;
	}
	
	public boolean removePontoDaRota (Rota r, Ponto p){
		
		for (int i = 0; i < r.getPontos().size(); i++) {
			if (r.getPontos().get(i).equals(p)){
				r.getPontos().remove(i);
				return true;
			}
		}
	
		return false;
	}
	
	public List<Ponto> pontosAntesIntegracao(){
		//TODO
		return null;
	}
	
	public List<Ponto> pontosDepoisIntegracao(){
		//TODO
		return null;
	}
	
	public List<Ponto> extrairPontos(String iFrame){
		//TODO
		return null;
	}
	
	public Tempo calculaProximaPassagem(Rota r, Tempo t){
		//TODO
		return null;
	}
	
	public Tempo calcularTodosHorarios(Rota r){
		//TODO
		return null;
	}
	
}
