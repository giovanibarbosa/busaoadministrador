package br.edu.ufcg.dsc.bean;

import java.sql.Date;

public class Horario {

	private int diferencaEntreOnibus;
	private int tempoPercursoTotal;
	private Date horaInicio;
	private Date horaTermino;

	public Horario(int diferencaEntreOnibus, int tempoPercursoTotal,
			Date horaInicio, Date horaTermino) {
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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		validaTempo(horaInicio, this.horaTermino);
		this.horaInicio = horaInicio;
	}

	public Date getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Date horaTermino) {
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

	private void validaTempo(Date tempoInicial, Date tempoFinal) {
		if (tempoInicial == null
				|| tempoFinal == null
				|| (tempoFinal.before(tempoInicial)))
			throw new IllegalArgumentException("Intervalo de tempo invalido");
	}
}
