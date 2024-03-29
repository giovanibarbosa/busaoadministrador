package br.edu.ufcg.dsc.bean;

public class Onibus {

	
	private String identificador;
	private int capacidade;
	private String rotaId;
	
	public Onibus (String identificador){
		validaIdentificador(identificador);
		this.identificador = identificador;
	}
	
	public Onibus (String identificador, int capacidade, String rotaId){
		validaIdentificador(identificador);
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
	
		this.capacidade = capacidade;
	}
	
	@Override
	public String toString() {
		return "Id: " + getIdentificador() + ". Capacidade: " + getCapacidade();
	}
	
	private void validaIdentificador(String identificador){
		if (identificador == null || identificador.trim().isEmpty())
			throw new IllegalArgumentException("Identificador invalido");
	}
	
}
