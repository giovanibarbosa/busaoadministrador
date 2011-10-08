package br.edu.ufcg.dsc.util;

public class Tempo {
	
	private int hora;
	private int minutos;
	
	public Tempo(int hora, int minutos) {
		validaHora(hora);
		validaMinuto(minutos);
		this.hora = hora;
		this.minutos = minutos;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		validaHora(hora);
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		validaMinuto(minutos);
		this.minutos = minutos;
	}
	
	public String toString() {
		return hora+"" + ":" + minutos+"" +"h";
	}
	
	private void validaHora(int hora){
		if (hora < 0 || hora > 23)
			throw new IllegalArgumentException("Hora invalida (nao esta no intervalo 0-23)");
		
	}
	private void validaMinuto(int minuto){
		if (minuto < 0 || minuto >59)
			throw new IllegalArgumentException("Minutos invalidos (nao estao no intervalo 0-59)");
	}
	
}
