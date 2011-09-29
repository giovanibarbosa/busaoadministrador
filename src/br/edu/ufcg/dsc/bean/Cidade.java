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
	
	public Cidade (int identificacao, String nomeCidade, String estado, Ponto ponto) {
		this.identificacao = identificacao;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		this.empresasCadastradas = new ArrayList<Empresa>();
	}

	public Cidade (int identificacao, double valorTarifa, String nomeCidade, String estado, Ponto ponto) {
		this.identificacao = identificacao;
		this.valorTarifa = valorTarifa;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		this.empresasCadastradas = new ArrayList<Empresa>();
	}
	
	public Cidade (double valorTarifa, String nomeCidade, String estado, Ponto ponto) {
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
		this.empresasCadastradas = empresasCadastradas;
	}

	public double getValorTarifa() {
		return valorTarifa;
	}


	public void setValorTarifa(double valorTarifa) {
		this.valorTarifa = valorTarifa;
	}


	public int getIdentificacao() {
		return identificacao;
	}


	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}


	public Ponto getPonto() {
		return ponto;
	}
	
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
