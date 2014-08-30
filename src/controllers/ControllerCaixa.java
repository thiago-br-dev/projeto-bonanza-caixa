package controllers;

import java.sql.SQLException;
import java.util.List;

import models.Caixa;
import repository.IRepositorioCaixa;
import repository.RepositorioCaixa;

public class ControllerCaixa {

	private IRepositorioCaixa caixaRepositorio;

	// GETs e SETs do clienteRepositorio
	// --------------------------------------------------------------------
	public IRepositorioCaixa caixaRepositorio() {
		return caixaRepositorio;
	}

	public void setCaixaRepositorio(IRepositorioCaixa caixaRepositorio) {
		this.caixaRepositorio = caixaRepositorio;
	}

	// -------------------------------------------------------------------
	public ControllerCaixa(RepositorioCaixa RepositorioCaixa) {
		this.setCaixaRepositorio(RepositorioCaixa);
	}

	// -------------------------------------------------------------------
	public List<Caixa> listar() throws SQLException {
		return caixaRepositorio.listarCaixa();
	}

	// -------------------------------------------------------------------

}
