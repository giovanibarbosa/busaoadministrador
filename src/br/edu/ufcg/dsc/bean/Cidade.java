package br.edu.ufcg.dsc.bean;



public class Cidade {

	private String nome;
	private String estado;
	private double valorTarifa;
	private int identificacao;
	private Ponto ponto;


	public Cidade(int identificacao, String nomeCidade, String estado,
			Ponto ponto) {
		validaId(identificacao);

		this.identificacao = identificacao;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		
	}

	public Cidade(int identificacao, double valorTarifa, String nomeCidade,
			String estado, Ponto ponto) {
		validaId(identificacao);
	
		this.identificacao = identificacao;
		this.valorTarifa = valorTarifa;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		
	}

	public Cidade(double valorTarifa, String nomeCidade, String estado,
			Ponto ponto) {

		this.identificacao = 0;
		this.valorTarifa = valorTarifa;
		this.nome = nomeCidade;
		this.estado = estado;
		this.ponto = ponto;
		
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
		validaId(identificacao);
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

	@Override
	public String toString() {
		return getNome() + " - " + getEstado() + ". Tarifa: "
				+ getValorTarifa() + ". " + getPonto();
	}

	

	
	

	private void validaId(int id) {
		if (id < 0)
			throw new IllegalArgumentException(
					"Identificacao de cidade invalida");
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
