package controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.Chamada;
import repository.IRepositorioChamada;
import repository.RepositorioChamada;

public class ControllerChamada {

	private IRepositorioChamada chamadaRepositorio;

	// GETs e SETs do chamadaRepositorio
	// --------------------------------------------------------------------
	public IRepositorioChamada caixaRepositorio() {
		return chamadaRepositorio;
	}

	public void setCaixaRepositorio(IRepositorioChamada chamadaRepositorio) {
		this.chamadaRepositorio = chamadaRepositorio;
	}

	// -------------------------------------------------------------------
	public ControllerChamada(RepositorioChamada RepositorioCaixa) {
		this.setCaixaRepositorio(RepositorioCaixa);
	}

	// -------------------------------------------------------------------
	public boolean inserir(Chamada chamada) throws SQLException {

		String dataSistema = new SimpleDateFormat("dd/MM/yyyy")
				.format(new Date());
		String horaSistema = new SimpleDateFormat("HH:mm").format(new Date());

		chamada.setData(dataSistema);
		chamada.setHora(horaSistema);
		return chamadaRepositorio.inserirChamada(chamada);
	}

	// -------------------------------------------------------------------
}
