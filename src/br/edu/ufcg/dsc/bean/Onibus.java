package br.edu.ufcg.dsc.bean;

public class Onibus {

	//Não coloquei integer, pois existem onibus com letras, exemplo: 093A
	private String identificador;
	private int capacidade;
	private String rotaId;
	
	public Onibus (String identificador){
		validaIdentificador(identificador);
		this.identificador = identificador;
	}
	
	public Onibus (String identificador, int capacidade, String rotaId){
		validaIdentificador(identificador);
		validaCapacidade(capacidade);
		validaRotaId(rotaId);
		this.identificador = identificador;
		this.capacidade = capacidade;
		this.rotaId = rotaId;
	}

	public String getRotaId() {
		return rotaId;
	}

	public void setRotaId(String rotaId) {
		this.rotaId = rotaId;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		validaIdentificador(identificador);
		this.identificador = identificador;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		validaCapacidade(capacidade);
		this.capacidade = capacidade;
	}
	
	@Override
	public String toString() {
		return "Identificador: " + getIdentificador() + ". Capacidade: " + getCapacidade();
	}
	
	private void validaIdentificador(String identificador){
		if (identificador == null || identificador.trim().isEmpty())
			throw new IllegalArgumentException("Identificador invalido");
	}
	private void validaCapacidade(int capacidade){
		if (capacidade <0)
			throw new IllegalArgumentException("Capacidade invalida");
	}
	
	private void validaRotaId(String rotaId){
		if (rotaId == null || rotaId.trim().isEmpty())
			throw new IllegalArgumentException("ID de rota invalida");
	}
}
