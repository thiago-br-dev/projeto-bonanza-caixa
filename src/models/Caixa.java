package models;

public class Caixa {

	private int id;
	private String caixa;
	private String atendente;
	private String dataHoraCadastro;
	private int AdministradorId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaixa() {
		return caixa;
	}
	public void setCaixa(String caixa) {
		this.caixa = caixa;
	}
	public String getAtendente() {
		return atendente;
	}
	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}
	public String getDataHoraCadastro() {
		return dataHoraCadastro;
	}
	public void setDataHoraCadastro(String dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}
	public int getAdministradorId() {
		return AdministradorId;
	}
	public void setAdministradorId(int administradorId) {
		AdministradorId = administradorId;
	}
	
	
}
