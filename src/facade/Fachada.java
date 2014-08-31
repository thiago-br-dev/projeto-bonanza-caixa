/**
 * interface que contempla todas as funcionalidades do sistema.
 * 
 * @author			Paulo Lima
 * @corporation 	TeckSoft 2014
 * @project 		Araujo Seguros
 * @version 		1.0 
 * @since			Release 1  16/02/2014
 */
package facade;

import java.sql.SQLException;
import java.util.List;

import models.Caixa;
import models.Chamada;
import repository.RepositorioCaixa;
import repository.RepositorioChamada;
import controllers.ControllerCaixa;
import controllers.ControllerChamada;

public class Fachada {

	private static Fachada instancia;
	private ControllerChamada chamada;
	private ControllerCaixa caixa;

	// Metodo para iniciar todos os Repositorios e controladores
	// ---------------------------------------------------------------------
	private void iniciarControladores() {
		RepositorioChamada rc = new RepositorioChamada();
		chamada = new ControllerChamada(rc);
		
		RepositorioCaixa ra = new RepositorioCaixa();
		caixa = new ControllerCaixa(ra);
	}

	// Contrutor da classe
	// ---------------------------------------------------------------------
	private Fachada() {
		iniciarControladores();
	}

	// Metodo para verificar se a fachada ja existe ou instancia o mesmo.
	// ---------------------------------------------------------------------
	public static Fachada getInstance() {

		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	// ---------------------------------------------------------------------
	// ************************* chamada *******************************
	// ---------------------------------------------------------------------
	public boolean inserirChamada(Chamada chamada)
			throws SQLException {
		return this.chamada.inserir(chamada);
	}
	// ---------------------------------------------------------------------
	// ************************* caixa *******************************
	// ---------------------------------------------------------------------
	public List<Caixa> listarCaixa() throws SQLException {
		return this.caixa.listar();
	}

	// ---------------------------------------------------------------------
	public Caixa buscarPorCaixa(String chave) throws SQLException {
		return this.caixa.buscarPorCaixa(chave);
	}

	// ---------------------------------------------------------------------
}
