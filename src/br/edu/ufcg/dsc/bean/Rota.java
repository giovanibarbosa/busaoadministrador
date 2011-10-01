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

	public Rota(String identificador, List<Ponto> pontos, Horario horario) {
		this.identificador = identificador;
		this.pontos = pontos;
		this.horario = horario;
		this.onibusParticipantes = new ArrayList<Onibus>();
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}

	public Rota(String identificador, List<Onibus> onibusParticipantes,
			List<Ponto> pontos, Horario horario) {
		this.identificador = identificador;
		this.onibusParticipantes = onibusParticipantes;
		this.pontos = pontos;
		this.horario = horario;
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}

	public Rota(String identificador, String cor, List<Ponto> pontos,
			Horario horario) {
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
		this.identificador = identificador;
		this.cor = cor;
		this.numeroVisualizacao = 0;
		this.onibusParticipantes = onibusParticipantes;
		this.pontos = pontos;
		this.horario = horario;
	}

	public Rota(String identificador, String cor, int numeroVisualizacao,
			Horario horario, int empresaId, String urlRota) {
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
		this.numeroVisualizacao = numeroVisualizacao;
	}

	public List<Onibus> getOnibusParticipantes() {
		return onibusParticipantes;
	}

	public void setOnibusParticipantes(List<Onibus> onibusParticipantes) {
		this.onibusParticipantes = onibusParticipantes;
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

}
