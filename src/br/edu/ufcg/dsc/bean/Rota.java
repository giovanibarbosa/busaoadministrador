package br.edu.ufcg.dsc.bean;

import java.util.ArrayList;
import java.util.List;

public class Rota {

	private String identificador;
	private String cor;
	private int numeroVisualizacao;
	private int empresaId;
	
	private List<Ponto> pontos;
	private Horario horario;
	private int numeroDeOnibus;	
	private String urlRota;
	private String via;

	
	public Rota(){
		this.pontos = new ArrayList<Ponto>();
		
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}
	
	public Rota(String identificador, List<Ponto> pontos, Horario horario, String via) {
		validaId(identificador);
	
		this.identificador = identificador;
		this.pontos = pontos;
		this.horario = horario;
		
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
		setVia(via);
	}

	public Rota(String identificador, List<Onibus> onibusParticipantes,
			String urlRota, Horario horario, String via) {
		validaId(identificador);
		

		this.identificador = identificador;
		
		this.horario = horario;
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
		this.urlRota = urlRota;
		setVia(via);
	}

	public Rota(String identificador, String cor, String urlRota,
			Horario horario, String via) {
		validaId(identificador);
		
	
		this.identificador = identificador;
		this.cor = cor;
		this.urlRota = urlRota;
		this.horario = horario;
		
		this.numeroVisualizacao = 0;
		setVia(via);
	}

	public Rota(String identificador, String cor,
			List<Onibus> onibusParticipantes, String urlRota,
			Horario horario, String via) {
		validaId(identificador);

		this.identificador = identificador;
		this.cor = cor;
		this.numeroVisualizacao = 0;
		
		this.urlRota = urlRota;
		this.horario = horario;
		setVia(via);
	}

	public Rota(String identificador, String cor, int numeroVisualizacao,
			Horario horario, int empresaId, String urlRota, int numeroDoOnibus, String via) {
		validaId(identificador);

		validaNumeroVisualizacao(numeroVisualizacao);

		this.identificador = identificador;
		this.cor = cor;
		this.numeroVisualizacao = numeroVisualizacao;
		this.horario = horario;
		this.empresaId = empresaId;
		this.urlRota = urlRota;
		this.numeroDeOnibus = numeroDoOnibus;
		setVia(via);
	}

	@Override
	public String toString() {
		return "Id: " + getIdentificador() + ". Cor: " + getCor()
				+ ". Número de visualização: " + getNumeroVisualizacao()
				+" " + getHorario();
	}
	
	public int getNumeroDoOnibus() {
		return numeroDeOnibus;
	}

	public void setNumeroDoOnibus(int numeroDoOnibus) {
		this.numeroDeOnibus = numeroDoOnibus;
	}

	public String getUrlRota() {
		return urlRota;
	}

	public void setUrlRota(String urlRota) {
		this.urlRota = urlRota;
	}

	public int getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		validaId(identificador);
		this.identificador = identificador;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
	
		this.cor = cor;
	}

	public int getNumeroVisualizacao() {
		return numeroVisualizacao;
	}

	public void setNumeroVisualizacao(int numeroVisualizacao) {
		validaNumeroVisualizacao(numeroVisualizacao);
		this.numeroVisualizacao = numeroVisualizacao;
	}


	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		
		this.pontos = pontos;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
	
		this.horario = horario;
	}
	
	private void validaId(String id){
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("Identificador invalido");
		
	}
	
	
	
	
	
	private void validaNumeroVisualizacao(int numero){
		if (numero < 0)
			throw new IllegalArgumentException("Numero de visualizacao invalido");
	}
	

	public void setVia(String via) {
		if (via == null)
			throw new IllegalArgumentException("Via nula");
		this.via = via;
	}

	public String getVia() {
		return via;
	}

}
