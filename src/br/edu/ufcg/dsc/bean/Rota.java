package br.edu.ufcg.dsc.bean;

import java.util.ArrayList;
import java.util.List;

public class Rota {
	
	private String identificador;
	private String cor;
	private int numeroVisualizacao;	
	private List<Onibus> onibusParticipantes;
	private List<Ponto> pontos;
	private Horario horario;
	
	public Rota(String identificador, List<Ponto> pontos, Horario horario) {
		this.identificador = identificador;
		this.pontos = pontos;
		this.horario = horario;
		this.onibusParticipantes = new ArrayList<Onibus>();
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}

	public Rota(String identificador, List<Onibus> onibusParticipantes, List<Ponto> pontos, Horario horario) {
		this.identificador = identificador;
		this.onibusParticipantes = onibusParticipantes;
		this.pontos = pontos;
		this.horario = horario;
		this.numeroVisualizacao = 0;
		this.cor = "Branco";
	}

	public Rota(String identificador, String cor, List<Ponto> pontos, Horario horario) {
		this.identificador = identificador;
		this.cor = cor;
		this.pontos = pontos;
		this.horario = horario;
		this.onibusParticipantes = new ArrayList<Onibus>();
		this.numeroVisualizacao = 0;
	}

	public Rota(String identificador, String cor, List<Onibus> onibusParticipantes, List<Ponto> pontos, Horario horario) {
		this.identificador = identificador;
		this.cor = cor;
		this.numeroVisualizacao = 0;
		this.onibusParticipantes = onibusParticipantes;
		this.pontos = pontos;
		this.horario = horario;
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
