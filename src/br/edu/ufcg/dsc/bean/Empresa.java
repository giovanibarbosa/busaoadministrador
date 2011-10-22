package br.edu.ufcg.dsc.bean;

public class Empresa {

	private int identificador;
	private String nome;
	private int anoFundacao;
	private int cidadeId;
	
	public Empresa(int identificador, String nome, int anoFundacao, int cidadeId) {
		validaId(identificador);
		validaNome(nome);
		this.identificador = identificador;
		this.nome = nome;
		this.anoFundacao = anoFundacao;
		this.cidadeId = cidadeId;
	}

	public Empresa(int identificador, String nome) {
		validaId(identificador);
		validaNome(nome);
		this.identificador = identificador;
		this.nome = nome;
		}

	@Override
	public String toString() {
		return "Id: " + getIdentificador() + ". Nome: " + getNome()
				+ ". Ano de fundacao: " + getAnoFundacao()+ ". Id da Cidade: " + getCidadeId();
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
		
		this.anoFundacao = anoFundacao;
	}

	public int getCidadeId() {
		return cidadeId;
	}

	public void setCidade(int cidadeId) {
		
		this.cidadeId = cidadeId;
	}
	
	private void validaId(int id){
		if (id < 0 )
			throw new IllegalArgumentException("Identificador de empresa invalido");
	}
	
	private void validaNome(String nome){
		if (nome == null )
			throw new IllegalArgumentException("Nome de empresa invalido");
	}
		
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Empresa)) return false;
		Empresa emp = (Empresa) obj;
		return emp.getIdentificador() == getIdentificador();
	}
}
