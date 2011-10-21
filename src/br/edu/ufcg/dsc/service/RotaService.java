package br.edu.ufcg.dsc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.bean.PontoDeRota;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.persistenceDAO.RotaDAO;
import java.sql.Date;

public class RotaService {

	private static RotaService instanciaUnica;
	private RotaDAO rd;
	private final Ponto INTEGRACAO = new Ponto(-7.219459, -35.889641);
	private final int MILISSEGUNDOS_PARA_MINUTO = 60000;

	private RotaService() throws SQLException {
		rd = RotaDAO.getInstance();
	}

	public static RotaService getInstance() throws SQLException {

		if (instanciaUnica == null) {
			RotaService rs = new RotaService();
			instanciaUnica = rs;
		}

		return instanciaUnica;

	}

	public void adicionaRota(Rota rota) throws 
			SQLException {
		rd.criar(rota);
	}

	public void removeRota(Rota rota) throws 
			SQLException {
		rd.deletar(rota);
	}

	public List<Rota> getRotas() throws SQLException {
		return rd.listarTodas();
	}

	public boolean adicionaOnibusNaRota(Rota r, Onibus o)
			throws IllegalArgumentException, SQLException {
		return rd.adicionaOnibus(r, o);
	}

	public boolean removeOnibusDaRota(Rota r, Onibus o)
			throws SQLException {
		return rd.removeOnibus(o, r);
	}

	public boolean adicionaPontoRota(Rota r, PontoDeRota p)
			throws SQLException {
		return rd.adicionaPonto(p, r);
	}

	public boolean removePontoDaRota(Rota r, PontoDeRota p)
			throws  SQLException {
		return rd.removePonto(p, r);
	}

	// TODO
	public List<String> pesquisaRota(String identificador) throws SQLException {
		List<Rota> allRotas = rd.listarTodas();
		List<String> rotasIds = new ArrayList<String>();

		for (Rota rota : allRotas) {
			if (rota.getIdentificador().contains(identificador))
				rotasIds.add(rota.getIdentificador());
		}
		return rotasIds;
	}

	public List<PontoDeRota> getPontos(String idRota)
			throws IllegalArgumentException, SQLException {
		return rd.recuperaPontos(rd.recuperar(idRota));
	}

	public String extrairPontos(Rota r) {
		return this.extrairPontos(r.getUrlRota());
	}

	// Aqui a gente tem que extrair pontos la do arquivo .kml
	public String extrairPontos(String iframe) {
		
		return iframe;
	}

	public String getTodosHorario(String idRota)
			throws IllegalArgumentException, SQLException {
		Rota r = null;
		r = rd.recuperar(idRota);

		return r.getHorario().toString();
	}

	public String getValor(String atributo, String idRota)
			throws IllegalArgumentException, SQLException {
		Rota r = null;
		r = rd.recuperar(idRota);

		if (atributo.equalsIgnoreCase("cor")) {
			return r.getCor();
		} else if (atributo.equalsIgnoreCase("urlRota")) {
			return r.getUrlRota();
		}

		return atributo + " Nao Encontrado";
	}

	public int calculaProximaPassagem(String idRota)
			throws IllegalArgumentException, SQLException {
		Rota r = null;
		r = rd.recuperar(idRota);

		// Transformar tudo para minutos
		
		// Pega hora do sistema e transfere pra minutos
		int horaAtual = (int) (System.currentTimeMillis() / MILISSEGUNDOS_PARA_MINUTO);

		// tempo de percurso passado em minutos
		int tempoPercurso = r.getHorario().getTempoPercursoTotal();

		// Resto da Divisao
		return ((horaAtual - r.getHorario().getHoraInicio().getMinutes()) % tempoPercurso);
	}

	public Date calcularTodosHorarios(Rota r) {
		// TODO
		return null;
	}

	public List<Ponto> pontosAntesIntegracao() {
		// TODO
		return null;
	}

	public List<Ponto> pontosDepoisIntegracao() {
		// TODO
		return null;
	}

}
