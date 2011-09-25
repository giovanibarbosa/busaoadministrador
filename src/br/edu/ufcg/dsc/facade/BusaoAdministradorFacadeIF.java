package br.edu.ufcg.dsc.facade;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.util.Tempo;

public interface BusaoAdministradorFacadeIF {
	
	public boolean adicionarCidade(Cidade c);
	
	public boolean removerCidade(Cidade c);
	
	public boolean adicionarOnibus(Onibus o);
	
	public boolean removerOnibus(Onibus o);
	
	public boolean adicionarEmpresa (Cidade c, Empresa empr);
	
	public boolean removerEmpresa (Cidade c, Empresa empr);
	
	public boolean alterarRota (Empresa emp, Rota r);
	
	public boolean removerRota (Empresa emp, Rota r);
	
	public boolean cadastrarRota (Empresa emp, Rota r);
	
	public Tempo calculaProximaPassagem (Rota r, Tempo temp);
	
	public Tempo calcularTodosHorarios (Rota r);
}
