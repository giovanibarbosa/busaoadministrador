package br.edu.ufcg.dsc.facade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.PontoDeRota;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.bean.Usuario;
import br.edu.ufcg.dsc.persistenceDAO.PontoDeRotaDAO;
import br.edu.ufcg.dsc.service.CidadeService;
import br.edu.ufcg.dsc.service.EmpresaService;
import br.edu.ufcg.dsc.service.OnibusService;
import br.edu.ufcg.dsc.service.RotaService;
import br.edu.ufcg.dsc.service.UsuarioService;



public class BusaoAdministradorFacade implements BusaoAdministradorFacadeIF {

	private CidadeService cs;
	private OnibusService os;
	private EmpresaService es;
	private RotaService rs;
	private UsuarioService us;
	private PontoDeRotaDAO pd;
	
	public BusaoAdministradorFacade() throws SQLException{
		cs = CidadeService.getInstance();
		os = OnibusService.getInstance();
		es = EmpresaService.getInstance();
		rs = RotaService.getInstance();
		us = UsuarioService.getInstance();
		pd = PontoDeRotaDAO.getInstance();
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
	public void adicionarEmpresa(Empresa empr) throws SQLException {
		es.adicionar(empr);
	}

	@Override
	public void removerEmpresa(Empresa empr) throws SQLException {
		 es.removeEmpresa(empr);
	}

	@Override
	public boolean alterarRota(Empresa emp, Rota r) {
		return es.alterarRota(emp, r);
	}

	@Override
	public void removerRota(Rota r) throws SQLException {
		rs.removeRota(r);
		//return es.removeRota(emp, r);
	}

	@Override
	public void cadastrarRota(Rota r) throws SQLException {
		rs.adicionaRota(r);
	}

	@Override
	public int calculaProximaPassagem(String idRota) throws SQLException {
		return rs.calculaProximaPassagem(idRota);
	}

	@Override
	public Date calcularTodosHorarios(Rota r) {
		return rs.calcularTodosHorarios(r);
	}

	@Override
	public Date calculaProximaPassagem(Rota r, Date temp) {
		
		return null;
	}
	
	public Object[] getCidades() throws SQLException{
		return  cs.getCidadesAplicativo().toArray();
	}

	public Empresa getEmpresa(int id) throws IllegalArgumentException, SQLException {
		return es.getEmpresaId(id);
	}
	
	public Cidade getCidade(int id) throws IllegalArgumentException, SQLException{
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

	public List<String> extrairRotas(String link) {
		return rs.extrairPontos(link);
	}

	public List<Rota> getRotas() throws SQLException{
		return rs.getRotas();
	}
	
	public Rota getRota(String id) throws SQLException{
		return rs.getRota(id);
	}
	
	public void adicionaUsuario(Usuario u) throws SQLException{
		us.adicionar(u);
	}

	public Usuario getUsuario(String login) throws SQLException {
		return us.recuperar(login);
		
	}
	
	public void addPontoRota(PontoDeRota ponto) throws SQLException{
		pd.criar(ponto);
	}
	
	public List<String> extraiPontos(String link){
		return rs.extrairPontos(link);
	}

}

