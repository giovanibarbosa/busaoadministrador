package br.edu.ufcg.dsc.bean;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private int identificador;
	private String nome;
	private int anoFundacao;
	private List<Rota> rotas;
	
	public Empresa(int identificador, String nome, int anoFundacao) {
		this.identificador = identificador;
		this.nome = nome;
		this.anoFundacao = anoFundacao;
		this.rotas = new ArrayList<Rota>();
	}
	
	public Empresa(int identificador, String nome) {
		this.identificador = identificador;
		this.nome = nome;
		this.rotas = new ArrayList<Rota>();
	}
	
	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	public int getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAnoFundacao() {
		return anoFundacao;
	}
	
	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}
}
