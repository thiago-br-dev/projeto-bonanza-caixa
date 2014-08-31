package models;

public class Chamada {

	private int id;
	private String data;
	private String hora;
	private String espera;
	private int caixaId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getCaixaId() {
		return caixaId;
	}
	public void setCaixaId(int caixaId) {
		this.caixaId = caixaId;
	}
	public String getEspera() {
		return espera;
	}
	public void setEspera(String espera) {
		this.espera = espera;
	}
	
	
}
