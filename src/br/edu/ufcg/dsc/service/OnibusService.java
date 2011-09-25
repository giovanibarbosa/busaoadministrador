package br.edu.ufcg.dsc.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.exceptions.IdentificadorInvalidoException;
import br.edu.ufcg.dsc.exceptions.OnibusNaoEncontradoException;
import br.edu.ufcg.dsc.exceptions.ParametroInvalidoException;

public class OnibusService {

	private static OnibusService instanciaUnica;
	private List<Onibus> onibus;
	
	public OnibusService () {
		this.onibus = new ArrayList<Onibus>();
	}
	
	public static OnibusService getInstance() {
		
		if (instanciaUnica == null){
			OnibusService os = new OnibusService();
			instanciaUnica = os;
		}
		
		return instanciaUnica;
		
	}
	
	public boolean addOnibus (Onibus o){
		
		if (!onibus.contains(o)){
			onibus.add(o);
			return true;
		}
		
		return false;
	}
	
	public boolean removeOnibus (Onibus o){
		for (int i = 0; i < onibus.size(); i++) {
			if (onibus.get(i).equals(o))
				onibus.remove(i);
				return true;
		}
		
		return false;
	}
	
	public List<Onibus> getOnibus (){
		return this.onibus;
	}
	
	public String getOnibusId (Onibus o){
		return o.getIdentificador();
	}
	
	public Onibus getOnibusPorId (String id) throws OnibusNaoEncontradoException{
		for (int i = 0; i < onibus.size(); i++) {
			if (onibus.get(i).getIdentificador().equals(id)){
				return onibus.get(i);
			}
		}
		
		throw new OnibusNaoEncontradoException();
	}

}
