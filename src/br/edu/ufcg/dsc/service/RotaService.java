package br.edu.ufcg.dsc.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Horario;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.persistenceDAO.RotaDAO;
import br.edu.ufcg.dsc.util.Tempo;


public class RotaService {

	private static RotaService instanciaUnica;
	//?????????
	private RotaDAO rd = RotaDAO.getInstance();
	private final Ponto INTEGRACAO = new Ponto (-7.219459, -35.889641);
	private final int MILISSEGUNDOS_PARA_MINUTO = 60000;
	
	public RotaService(){}
	
	public static RotaService getInstance() {
		
		if (instanciaUnica == null){
			RotaService rs = new RotaService();
			instanciaUnica = rs;
		}
		
		return instanciaUnica;
		
	}
	
	public void adicionaRota(Rota rota) throws IllegalArgumentException, SQLException {
		rd.criar(rota);
	}
	
	public void removeRota (Rota rota) throws IllegalArgumentException, SQLException{
		rd.deletar(rota);
	}
	
	public List<Rota> getRotas() throws SQLException{
		return rd.listarTodas();
	}
	
	//Ver como fica isso no DAO
	public boolean adicionaOnibusNaRota (Rota r, Onibus o){
		
		if (!r.getOnibusParticipantes().contains(o)){
			r.getOnibusParticipantes().add(o);
			return true;
		}
		
		return false;
	}
	
	//Ver como fica isso no DAO
	public boolean removeOnibusDaRota (Rota r, Onibus o){
		
		for (int i = 0; i < r.getOnibusParticipantes().size(); i++) {
			if (r.getOnibusParticipantes().get(i).equals(o)){
				r.getOnibusParticipantes().remove(i);
				return true;
			}
		}
	
		return false;
	}

	//Ver como fica isso no DAO
	public boolean adicionaPontoRota (Rota r, Ponto p){
		
		if (!r.getPontos().contains(p)){
			r.getPontos().add(p);
			return true;
		}
		
		return false;
	}
	
	//Ver como fica isso no DAO
	public boolean removePontoDaRota (Rota r, Ponto p){
		
		for (int i = 0; i < r.getPontos().size(); i++) {
			if (r.getPontos().get(i).equals(p)){
				r.getPontos().remove(i);
				return true;
			}
		}
	
		return false;
	}
	
	//Ve isso aqui direitinho. Tenho duvida
	@SuppressWarnings("unchecked")
	public List<String> pesquisaRota (String identificador) throws SQLException{
		return (List<String>) rd.pesquisaRota(identificador);
	}
	
	public List<Ponto> getPontos(String idRota) throws IllegalArgumentException, SQLException{
		Rota r = new Rota();
		r = rd.recuperar(idRota);
		
		return this.extrairPontos(r);
	}
	
	public List<Ponto> extrairPontos(Rota r){
		return this.extrairPontos(r.getUrlRota());
	}
	
	//Aqui a gente tem que extrair pontos la do arquivo .kml
	public List<Ponto> extrairPontos(String iframe){
		//TODO
		return null;
	}
	
	public String getTodosHorario(String idRota) throws IllegalArgumentException, SQLException{
		Rota r = null;
		r = rd.recuperar(idRota);
		
		return r.getHorario().toString();
	}
	
	public String getValor(String atributo, String idRota) throws IllegalArgumentException, SQLException{
		Rota r = null;
		r = rd.recuperar(idRota);
		
		if (atributo.equalsIgnoreCase("cor")){
			return r.getCor();
		} else if (atributo.equalsIgnoreCase("urlRota")){
			return r.getUrlRota();
		}
		
		return atributo + " Nao Encontrado";
	}
	
	public int calculaProximaPassagem(String idRota) throws IllegalArgumentException, SQLException{
		Rota r = null;
		r = rd.recuperar(idRota);
		
		//Transformar tudo para minutos
		int horaInicial = (r.getHorario().getHoraInicio().getHora() * 60) + r.getHorario().getHoraInicio().getMinutos();
		
		//Pega hora do sistema e transfere pra minutos
		int horaAtual = (int)(System.currentTimeMillis() / MILISSEGUNDOS_PARA_MINUTO);
		
		//tempo de percurso passado em minutos
		int tempoPercurso = r.getHorario().getTempoPercursoTotal();
		
		//Resto da Divisao
		return ( (horaAtual-horaInicial) % tempoPercurso);
	}
	
	public Tempo calcularTodosHorarios(Rota r){
		//TODO
		return null;
	}
	
	public List<Ponto> pontosAntesIntegracao(){
		//TODO
		return null;
	}
	
	public List<Ponto> pontosDepoisIntegracao(){
		//TODO
		return null;
	}
	
}
