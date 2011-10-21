package br.edu.ufcg.dsc.bean;

import java.sql.Time;

public class Horario {

	private int diferencaEntreOnibus;
	private int tempoPercursoTotal;
	private Time horaInicio;
	private Time horaTermino;

	public Horario(int diferencaEntreOnibus, int tempoPercursoTotal,
			Time horaInicio, Time horaTermino) {

		this.diferencaEntreOnibus = diferencaEntreOnibus;
		this.tempoPercursoTotal = tempoPercursoTotal;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
	}

	@Override
	public String toString() {
		return "Diferença entre onibus: " + getDiferencaEntreOnibus()
				+ ". Tempo total do percusso: " + getTempoPercursoTotal()
				+ ". Horário de início: " + getHoraInicio()
				+ ". Horário de término: " + getHoraTermino();
	}

	public int getDiferencaEntreOnibus() {
		return diferencaEntreOnibus;
	}

	public void setDiferencaEntreOnibus(int diferencaEntreOnibus) {
		
		this.diferencaEntreOnibus = diferencaEntreOnibus;
	}

	public int getTempoPercursoTotal() {
		return tempoPercursoTotal;
	}

	public void setTempoPercursoTotal(int tempoPercursoTotal) {
		
		this.tempoPercursoTotal = tempoPercursoTotal;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		
		this.horaInicio = horaInicio;
	}

	public Time getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Time horaTermino) {
		
		this.horaTermino = horaTermino;
	}

}
