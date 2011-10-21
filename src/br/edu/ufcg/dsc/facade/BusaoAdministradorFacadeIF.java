package br.edu.ufcg.dsc.facade;

import java.sql.SQLException;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Rota;
import java.sql.Date;

public interface BusaoAdministradorFacadeIF {
	
	public void adicionarCidade(Cidade c) throws IllegalArgumentException, SQLException;
	
	public void removerCidade(Cidade c) throws IllegalArgumentException, SQLException;
	
	public void adicionarOnibus(Onibus o) throws IllegalArgumentException, SQLException;
	
	public void removerOnibus(Onibus o) throws IllegalArgumentException, SQLException;
	
	public void adicionarEmpresa (Empresa empr) throws  SQLException;
	
	public void removerEmpresa (Empresa empr) throws  SQLException;
	
	public boolean alterarRota (Empresa emp, Rota r);
	
	public void removerRota ( Rota r) throws SQLException;
	
	public void cadastrarRota (Rota r) throws  SQLException;
	
	public Date calculaProximaPassagem (Rota r, Date temp);
	
	public Date calcularTodosHorarios (Rota r);

	int calculaProximaPassagem(String idRota) throws IllegalArgumentException, SQLException;
}
