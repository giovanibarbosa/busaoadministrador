package br.edu.ufcg.dsc.service;

import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.bean.PontoDeRota;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.persistenceDAO.RotaDAO;
import java.sql.Date;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

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

	public boolean adicionaPontoRota(Rota r, PontoDeRota p)
			throws SQLException {
		return rd.adicionaPonto(p, r);
	}

	public boolean removePontoDaRota(Rota r, PontoDeRota p)
			throws  SQLException {
		return rd.removePonto(p, r);
	}

	
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

	public List<String> extrairPontos(Rota r) {
		return this.extrairPontos(r.getUrlRota());
	}

	/**
	 * Metodo que extrai todos os pontos que estao dentro de um arquivo KML passado pelo criador da Rota
	 * Esse arquivo é baseado em um arquivo XML. É usado a api JDOM para fazer a leitura do arquvio
	 * @param url - a url do arquivo KML a ser extraido os pontos
	 * @return List - Uma lista de todas as Rotas no formato: [latitude,longitude]
	 */
	public List<String> extrairPontos(String url) {
		if(url == null || url.equals("")){
			return new ArrayList<String>();
		}
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();
		try {
			URLConnection conn = new URL(url).openConnection();
			doc = builder.build(conn.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Element agenda = doc.getRootElement();
		List<Element> lista = agenda.getChildren();
		lista = lista.get(0).getChildren();
		List<String> pontosEncontrados = new ArrayList<String>();
		for (Element e : lista) {
			if (e.getName().equals("Placemark")){
				List<Element> nodosFilhos = e.getChildren();
				for (Element filho : nodosFilhos){
					if(filho.getName().equals("LineString")){
						List<Element> nodosNetos = filho.getChildren();
						String[] ponto = new String[2];
						for (Element neto : nodosNetos){
							if (neto.getName().equals("coordinates")){
								List<String> pontosString = getPontosDaString(neto.getText());
								for (String cordenada : pontosString) {
									if(!pontosEncontrados.contains(cordenada)){
										pontosEncontrados.add(cordenada);
									}
								}
								
							}
							
						}
					}
					
				}
			}

		}
		return pontosEncontrados;
	}
	
	/**
	 * Metodo que extrai pontos de uma dadas String
	 * @param pontos - String contendo todos os pontos
	 * @return List - Lista de todos os pontos encontradas nessa String.
	 */
	private List<String> getPontosDaString(String pontos){
		pontos = pontos.replaceAll(" ", "");
		List<String> pontosEncontrados = new ArrayList<String>();
		String[] linhas = pontos.split("\n");
		for (String string : linhas) {
			String[] cordenadas = string.split(",");
			if(cordenadas.length == 3){
				String cordenada = cordenadas[1]+","+cordenadas[0];
				pontosEncontrados.add(cordenada);			
				
			}
		}
		return pontosEncontrados;
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

	@SuppressWarnings("deprecation")
	public int calculaProximaPassagem(String idRota)
			throws IllegalArgumentException, SQLException {
		Rota r = null;
		r = rd.recuperar(idRota);

		int horaAtual = (int) (System.currentTimeMillis() / MILISSEGUNDOS_PARA_MINUTO);
		int tempoPercurso = r.getHorario().getTempoPercursoTotal();

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

	public Rota getRota(String id) throws SQLException {
		
		return rd.recuperar(id);
	}

}
