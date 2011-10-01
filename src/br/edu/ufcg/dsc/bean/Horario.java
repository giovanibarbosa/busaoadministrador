package br.edu.ufcg.dsc.bean;

import br.edu.ufcg.dsc.util.Tempo;

public class Horario {

	private int diferencaEntreOnibus;
	private int tempoPercursoTotal;
	private Tempo horaInicio;
	private Tempo horaTermino;

	public Horario(int diferencaEntreOnibus, int tempoPercursoTotal,
			Tempo horaInicio, Tempo horaTermino) {
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

	public Tempo getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Tempo horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Tempo getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Tempo horaTermino) {
		this.horaTermino = horaTermino;
	}

}
