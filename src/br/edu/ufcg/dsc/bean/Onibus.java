package br.edu.ufcg.dsc.bean;

public class Onibus {

	//Não coloquei integer, pois existem onibus com letras, exemplo: 093A
	private String identificador;
	private int capacidade;
	
	public Onibus (String identificador){
		this.identificador = identificador;
	}
	
	public Onibus (String identificador, int capacidade){
		this.identificador = identificador;
		this.capacidade = capacidade;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
}
