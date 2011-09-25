package br.edu.ufcg.dsc.bean;

import java.util.ArrayList;
import java.util.List;

public class Cidade {

	private String nome;
	private String estado;
	private int valorTarifa;
	private int identificacao;
	private Ponto latitude;
	private Ponto longitude;
	private List<Empresa> empresasCadastradas;
	
	public Cidade (int identificacao, String nomeCidade, String estado, Ponto latitude, Ponto longitude) {
		this.identificacao = identificacao;
		this.nome = nomeCidade;
		this.estado = estado;
		this.latitude = latitude;
		this.longitude = longitude;
		this.empresasCadastradas = new ArrayList<Empresa>();
	}

	public Cidade (int identificacao, int valorTarifa, String nomeCidade, String estado, Ponto latitude, Ponto longitude) {
		this.identificacao = identificacao;
		this.valorTarifa = valorTarifa;
		this.nome = nomeCidade;
		this.estado = estado;
		this.latitude = latitude;
		this.longitude = longitude;
		this.empresasCadastradas = new ArrayList<Empresa>();
	}
	

	public List<Empresa> getEmpresasCadastradas() {
		return empresasCadastradas;
	}

	public void setEmpresasCadastradas(List<Empresa> empresasCadastradas) {
		this.empresasCadastradas = empresasCadastradas;
	}

	public int getValorTarifa() {
		return valorTarifa;
	}


	public void setValorTarifa(int valorTarifa) {
		this.valorTarifa = valorTarifa;
	}


	public int getIdentificacao() {
		return identificacao;
	}


	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}


	public Ponto getLatitude() {
		return latitude;
	}


	public void setLatitude(Ponto latitude) {
		this.latitude = latitude;
	}


	public Ponto getLongitude() {
		return longitude;
	}


	public void setLongitude(Ponto longitude) {
		this.longitude = longitude;
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
