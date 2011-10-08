package br.edu.ufcg.dsc.bean;

public class Ponto {

	private double longitude;
	private double latitude;
	
	public Ponto(double longitude, double latitude) {
		validaLatitude(latitude);
		validaLongitude(longitude);
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		validaLongitude(longitude);
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		validaLatitude(latitude);
		this.latitude = latitude;
	}
	
	@Override
	public String toString() {
		return "Latitude: " + getLatitude() + ", Longitude: " + getLongitude();
	}
	
	private void validaLongitude(double longitude){
		if (longitude < 0){
			throw new IllegalArgumentException("Longitude invalida");
		}
	}
	
	private void validaLatitude(double latitude){
		if (latitude < 0){
			throw new IllegalArgumentException("Latitude invalida");
		}
	}
}
