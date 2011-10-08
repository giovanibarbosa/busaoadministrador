package br.edu.ufcg.dsc.bean;

import br.edu.ufcg.dsc.util.Tempo;

public class Horario {

	private int diferencaEntreOnibus;
	private int tempoPercursoTotal;
	private Tempo horaInicio;
	private Tempo horaTermino;

	public Horario(int diferencaEntreOnibus, int tempoPercursoTotal,
			Tempo horaInicio, Tempo horaTermino) {
		validaDiferenca(diferencaEntreOnibus);
		validaPercurso(tempoPercursoTotal);
		validaTempo(horaInicio, horaTermino);
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
		validaDiferenca(diferencaEntreOnibus);
		this.diferencaEntreOnibus = diferencaEntreOnibus;
	}

	public int getTempoPercursoTotal() {
		return tempoPercursoTotal;
	}

	public void setTempoPercursoTotal(int tempoPercursoTotal) {
		validaPercurso(tempoPercursoTotal);
		this.tempoPercursoTotal = tempoPercursoTotal;
	}

	public Tempo getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Tempo horaInicio) {
		validaTempo(horaInicio, this.horaTermino);
		this.horaInicio = horaInicio;
	}

	public Tempo getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Tempo horaTermino) {
		validaTempo(this.horaInicio, horaTermino);
		this.horaTermino = horaTermino;
	}

	private void validaDiferenca(int dif) {
		if (dif <= 0)
			throw new IllegalArgumentException(
					"Diferenca de tempo entre onibus invalida");
	}

	private void validaPercurso(int percurso) {
		if (percurso <= 0)
			throw new IllegalArgumentException(
					"Tempo de percurso total invalido");
	}

	private void validaTempo(Tempo tempoInicial, Tempo tempoFinal) {
		if (tempoInicial == null
				|| tempoFinal == null
				|| (tempoFinal.getHora() <= tempoInicial.getHora() && tempoFinal
						.getMinutos() <= tempoInicial.getMinutos()))
			throw new IllegalArgumentException("Intervalo de tempo invalido");
	}
}
