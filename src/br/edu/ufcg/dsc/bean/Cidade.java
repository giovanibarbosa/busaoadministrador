package br.edu.ufcg.dsc.bean;

import java.util.ArrayList;
import java.util.List;

public class Cidade {

	private String nome;
	private String estado;
	private double valorTarifa;
	private int identificacao;
	private Ponto ponto;
	private List<Empresa> empresasCadastradas;

	public Cidade(int identificacao, String nomeCidade, String estado,
			Ponto ponto) {
		validaId(identificacao);
		validaNome(nomeCidade);
		validaEstado(estado);
		validaPonto(ponto);
		this.identificacao = identificacao;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		this.empresasCadastradas = new ArrayList<Empresa>();
	}

	public Cidade(int identificacao, double valorTarifa, String nomeCidade,
			String estado, Ponto ponto) {
		validaId(identificacao);
		validaNome(nomeCidade);
		validaEstado(estado);
		validaPonto(ponto);
		validaTarifa(valorTarifa);
		this.identificacao = identificacao;
		this.valorTarifa = valorTarifa;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		this.empresasCadastradas = new ArrayList<Empresa>();
	}

	public Cidade(double valorTarifa, String nomeCidade, String estado,
			Ponto ponto) {
		validaTarifa(valorTarifa);
		validaNome(nomeCidade);
		validaEstado(estado);
		validaPonto(ponto);
		this.identificacao = 0;
		this.valorTarifa = valorTarifa;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		this.empresasCadastradas = new ArrayList<Empresa>();
	}

	public List<Empresa> getEmpresasCadastradas() {
		return empresasCadastradas;
	}

	public void setEmpresasCadastradas(List<Empresa> empresasCadastradas) {
		if (empresasCadastradas == null || empresasCadastradas.isEmpty())
			throw new IllegalArgumentException("Lista de empresas vazia");
		this.empresasCadastradas = empresasCadastradas;
	}

	public double getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(double valorTarifa) {
		validaTarifa(valorTarifa);
		this.valorTarifa = valorTarifa;
	}

	public int getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(int identificacao) {
		validaId(identificacao);
		this.identificacao = identificacao;
	}

	public Ponto getPonto() {
		return ponto;
	}

	public void setPonto(Ponto ponto) {
		validaPonto(ponto);
		this.ponto = ponto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validaNome(nome);
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		validaEstado(estado);
		this.estado = estado;
	}

	@Override
	public String toString() {
		return getNome() + " - " + getEstado() + ". Tarifa: "
				+ getValorTarifa() + ". " + getPonto();
	}

	private void validaNome(String nome) {
		if (nome == null || nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome de cidade invalido");
	}

	private void validaEstado(String estado) {
		if (estado == null || estado.trim().isEmpty())
			throw new IllegalArgumentException("Estado invalido");

	}

	private void validaTarifa(double valorTarifa) {
		if (valorTarifa <= 0)
			throw new IllegalArgumentException(
					"Valor de tarifa menor ou igual a zero");
	}

	private void validaId(int id) {
		if (id < 0)
			throw new IllegalArgumentException(
					"Identificacao de cidade invalida");
	}

	private void validaPonto(Ponto ponto) {
		if (ponto == null)
			throw new IllegalArgumentException("Ponto invalido");
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cidade))
			return false;
		Cidade cd = (Cidade) obj;
		return cd.getIdentificacao() == getIdentificacao()
				&& cd.getNome() == getNome();
	}
}
