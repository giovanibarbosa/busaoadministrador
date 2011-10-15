package br.edu.ufcg.dsc.facade;

import java.awt.Component;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.service.CidadeService;
import br.edu.ufcg.dsc.service.EmpresaService;
import br.edu.ufcg.dsc.service.OnibusService;
import br.edu.ufcg.dsc.service.RotaService;
import br.edu.ufcg.dsc.util.Tempo;


public class BusaoAdministradorFacade implements BusaoAdministradorFacadeIF {

	private CidadeService cs;
	private OnibusService os;
	private EmpresaService es;
	private RotaService rs;
	
	public BusaoAdministradorFacade() throws SQLException{
		cs = CidadeService.getInstance();
		os = OnibusService.getInstance();
		es = EmpresaService.getInstance();
		rs = RotaService.getInstance();
	}

	@Override
	public void adicionarCidade(Cidade c) throws IllegalArgumentException, SQLException {
		cs.adicionarCidade(c);
	}

	@Override
	public void removerCidade(Cidade c) throws IllegalArgumentException, SQLException {
		cs.removeCidade(c);
	}

	@Override
	public void adicionarOnibus(Onibus o) throws IllegalArgumentException, SQLException {
		os.addOnibus(o);
	}

	@Override
	public void removerOnibus(Onibus o) throws IllegalArgumentException, SQLException {
		os.removeOnibus(o);
	}

	@Override
	public boolean adicionarEmpresa(Cidade c, Empresa empr) throws IllegalArgumentException, SQLException {
		return cs.adicionaEmpresa(c, empr);
	}

	@Override
	public boolean removerEmpresa(Cidade c, Empresa empr) throws IllegalArgumentException, SQLException {
		return cs.removeEmpresa(c, empr);
	}

	@Override
	public boolean alterarRota(Empresa emp, Rota r) {
		return es.alterarRota(emp, r);
	}

	@Override
	public boolean removerRota(Empresa emp, Rota r) {
		return es.removeRota(emp, r);
	}

	@Override
	public boolean cadastrarRota(Empresa emp, Rota r) {
		return es.adicionaRota(emp, r);
	}

	@Override
	public int calculaProximaPassagem(String idRota) throws SQLException {
		return rs.calculaProximaPassagem(idRota);
	}

	@Override
	public Tempo calcularTodosHorarios(Rota r) {
		return rs.calcularTodosHorarios(r);
	}

	@Override
	public Tempo calculaProximaPassagem(Rota r, Tempo temp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Object[] getCidades() throws SQLException{
		return  cs.getCidadesAplicativo().toArray();
	}

	public Empresa getEmpresa(int id) throws IllegalArgumentException, SQLException {
		return es.getEmpresaId(id);
	}
	
	public Cidade getCidade(String id) throws IllegalArgumentException, SQLException{
		return cs.getCidadePorId(id);
	}

	public List<Empresa> getEmpresas() throws SQLException {
			return es.getEmpresas();
	}
	
	public Onibus getOnibus(String id) throws IllegalArgumentException, SQLException{
		return os.getOnibusPorId(id);
	}
	
	public List<Onibus> getOnibus() throws SQLException {
		return os.getOnibus();
	}

	public List<Ponto> extrairRotas(String link) {
		return rs.extrairPontos(link);
	}
	
	

}

