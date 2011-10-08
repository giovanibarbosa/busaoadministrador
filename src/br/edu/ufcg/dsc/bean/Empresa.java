package br.edu.ufcg.dsc.bean;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private int identificador;
	private String nome;
	private int anoFundacao;
	private int cidadeId;
	private List<Rota> rotas;

	public Empresa(int identificador, String nome, int anoFundacao, int cidadeId) {
		validaId(identificador);
		validaNome(nome);
		validaAnoFundacao(anoFundacao);
		validaIdCidade(cidadeId);
		this.identificador = identificador;
		this.nome = nome;
		this.anoFundacao = anoFundacao;
		this.rotas = new ArrayList<Rota>();
		this.cidadeId = cidadeId;
	}

	public Empresa(int identificador, String nome) {
		validaId(identificador);
		validaNome(nome);
		this.identificador = identificador;
		this.nome = nome;
		this.rotas = new ArrayList<Rota>();
	}

	@Override
	public String toString() {
		return "Identificador: " + getIdentificador() + ". Nome: " + getNome()
				+ ". Ano de fundação: " + getAnoFundacao();
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		if (rotas == null || rotas.isEmpty())
			throw new IllegalArgumentException("Lista de rotas invalida");
		this.rotas = rotas;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		validaId(identificador);
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validaNome(nome);
		this.nome = nome;
	}

	public int getAnoFundacao() {
		return anoFundacao;
	}

	public void setAnoFundacao(int anoFundacao) {
		validaAnoFundacao(anoFundacao);
		this.anoFundacao = anoFundacao;
	}

	public int getCidadeId() {
		return cidadeId;
	}

	public void setCidade(int cidadeId) {
		validaIdCidade(cidadeId);
		this.cidadeId = cidadeId;
	}
	
	private void validaId(int id){
		if (id < 0 )
			throw new IllegalArgumentException("Identificador de empresa invalido");
	}
	private void validaNome(String nome){
		if (nome == null || nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome de empresa invalido");
	}
	private void validaAnoFundacao(int anoFundacao){
		if (anoFundacao < 1900 )
			throw new IllegalArgumentException("Ano de fundacao invalido");
	}
	private void validaIdCidade(int cidadeId){
		if (cidadeId < 0 )
			throw new IllegalArgumentException("Identificador de cidade invalido");
	}

}
