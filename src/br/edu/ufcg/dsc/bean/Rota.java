package br.edu.ufcg.dsc.bean;

import java.util.ArrayList;
import java.util.List;

public class Rota {

	private String identificador;
	private String cor;
	private int numeroVisualizacao;
	private int empresaId;
	private List<Onibus> onibusParticipantes;
	private List<Ponto> pontos;
	private Horario horario;
	private String urlRota;

	
	public Rota(){
		this.pontos = new ArrayList<Ponto>();
		this.onibusParticipantes = new ArrayList<Onibus>();
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}
	
	public Rota(String identificador, List<Ponto> pontos, Horario horario) {
		validaId(identificador);
		validaPontos(pontos);
		validaHorario(horario);
		this.identificador = identificador;
		this.pontos = pontos;
		this.horario = horario;
		this.onibusParticipantes = new ArrayList<Onibus>();
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}

	public Rota(String identificador, List<Onibus> onibusParticipantes,
			List<Ponto> pontos, Horario horario) {
		validaId(identificador);
		validaPontos(pontos);
		validaHorario(horario);
		validaOnibus(onibusParticipantes);
		this.identificador = identificador;
		this.onibusParticipantes = onibusParticipantes;
		this.pontos = pontos;
		this.horario = horario;
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}

	public Rota(String identificador, String cor, List<Ponto> pontos,
			Horario horario) {
		validaId(identificador);
		validaPontos(pontos);
		validaHorario(horario);
		validaCor(cor);
		this.identificador = identificador;
		this.cor = cor;
		this.pontos = pontos;
		this.horario = horario;
		this.onibusParticipantes = new ArrayList<Onibus>();
		this.numeroVisualizacao = 0;
	}

	public Rota(String identificador, String cor,
			List<Onibus> onibusParticipantes, List<Ponto> pontos,
			Horario horario) {
		validaId(identificador);
		validaPontos(pontos);
		validaHorario(horario);
		validaCor(cor);
		validaOnibus(onibusParticipantes);
		this.identificador = identificador;
		this.cor = cor;
		this.numeroVisualizacao = 0;
		this.onibusParticipantes = onibusParticipantes;
		this.pontos = pontos;
		this.horario = horario;
	}

	public Rota(String identificador, String cor, int numeroVisualizacao,
			Horario horario, int empresaId, String urlRota) {
		validaId(identificador);
		validaHorario(horario);
		validaCor(cor);
		validaNumeroVisualizacao(numeroVisualizacao);
		validaIdEmpresa(empresaId);
		validaUrl(urlRota);
		this.identificador = identificador;
		this.cor = cor;
		this.numeroVisualizacao = numeroVisualizacao;
		this.horario = horario;
		this.empresaId = empresaId;
		this.urlRota = urlRota;
	}

	@Override
	public String toString() {
		return "Identificador: " + getIdentificador() + ". Cor: "
				+ ". Número de visualização: " + getNumeroVisualizacao()
				+ getHorario();
	}

	public String getUrlRota() {
		return urlRota;
	}

	public void setUrlRota(String urlRota) {
		validaUrl(urlRota);
		this.urlRota = urlRota;
	}

	public int getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(int empresaId) {
		validaIdEmpresa(empresaId);
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
		validaCor(cor);
		this.cor = cor;
	}

	public int getNumeroVisualizacao() {
		return numeroVisualizacao;
	}

	public void setNumeroVisualizacao(int numeroVisualizacao) {
		validaNumeroVisualizacao(numeroVisualizacao);
		this.numeroVisualizacao = numeroVisualizacao;
	}

	public List<Onibus> getOnibusParticipantes() {
		return onibusParticipantes;
	}

	public void setOnibusParticipantes(List<Onibus> onibusParticipantes) {
		validaOnibus(onibusParticipantes);
		this.onibusParticipantes = onibusParticipantes;
	}

	public List<Ponto> getPontos() {
		return pontos;
	}

	public void setPontos(List<Ponto> pontos) {
		validaPontos(pontos);
		this.pontos = pontos;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		validaHorario(horario);
		this.horario = horario;
	}
	
	private void validaId(String id){
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("Identificador invalido");
		
	}
	
	private void validaCor(String cor){
		if (cor == null || cor.trim().isEmpty())
			throw new IllegalArgumentException("Cor invalida");
		
	}
	private void validaUrl(String valor){
		if (valor == null || valor.trim().isEmpty())
			throw new IllegalArgumentException("URL invalida");
		
	}
	private void validaIdEmpresa(int id){
		if (id <0)
			throw new IllegalArgumentException("ID da empresa invalido");
	}
	
	private void validaNumeroVisualizacao(int numero){
		if (numero <0)
			throw new IllegalArgumentException("Numero de visualizacao invalido");
	}
	private void validaHorario(Horario horario){
		if (horario == null)
			throw new IllegalArgumentException("Horario invalido");
	}
	private void validaPontos(List<Ponto> pontos){
		if (pontos == null )
			throw new IllegalArgumentException("Lista de pontos invalida");
	}
	
	private void validaOnibus(List<Onibus> onibus){
		if (onibus == null )
			throw new IllegalArgumentException("Lista de onibus invalida");
	}

}
