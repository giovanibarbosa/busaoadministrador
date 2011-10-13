package br.edu.ufcg.dsc.bean;

public class PontoDeRota extends Ponto {
	private int id;
	private String rotaId;

	public PontoDeRota(double longitude, double latitude) {
		super(longitude, latitude);
	}
	
	public PontoDeRota(double longitude, double latitude, String rotaId) {
		this(longitude, latitude);
		this.rotaId = rotaId;
	}
	
	public PontoDeRota(int id, double longitude, double latitude, String rotaId) {
		this(longitude, latitude);
		this.id = id;
		this.rotaId = rotaId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRotaId() {
		return rotaId;
	}

	public void setRotaId(String rotaId) {
		this.rotaId = rotaId;
	}	

}
